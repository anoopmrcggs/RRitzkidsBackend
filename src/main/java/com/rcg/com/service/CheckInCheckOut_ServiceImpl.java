package com.rcg.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.AuthorizedRelation;
import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dao.Language;
import com.rcg.com.dao.MedicalDetails;
import com.rcg.com.dao.YoungGust;
import com.rcg.com.dto.AuthorizedRelationDto;
import com.rcg.com.dto.CheckInCheckOutDto;
import com.rcg.com.dto.MedicalDetailsDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.AuthorizedRelationRepository;
import com.rcg.com.repository.CheckInCheckOutRepository;
import com.rcg.com.repository.GuardianRepository;
import com.rcg.com.repository.LanguageRepository;
import com.rcg.com.repository.MedicalDetailsRepository;
import com.rcg.com.repository.RelationshipRepository;
import com.rcg.com.repository.YoungGustRepository;
import com.rcg.com.util.RitzConstants;

@Service
public class CheckInCheckOut_ServiceImpl implements CheckInCheckOut_Service 
{
	@Autowired
	private MedicalDetailsRepository mr;
	
	@Autowired
	private AuthorizedRelationRepository ar;
	
	@Autowired
	private CheckInCheckOutRepository cr;
	
	
	@Autowired
	private YoungGustRepository ygr;
	
	@Autowired
	private RelationshipRepository rr;
	
	@Autowired
	private GuardianRepository gr; 
	
	@Autowired
	private LanguageRepository lr;

	
	//Saving Checkin checkout form
	
	@Override
	public int saveCheckInCheckoutForm(CheckInCheckOutDto checkincheckoutdto ) throws RitzkidsException 
	{
		
		Optional<YoungGust> ygo=null;
		
		CheckInCheckOut checkform=checkincheckoutMapper(checkincheckoutdto);

		//Setting Language
		if(checkincheckoutdto.getLanguage()!=null)
		{
				
			if(!lr.findById(checkincheckoutdto.getLanguage().getLid()).isPresent())
			{
				throw new RitzkidsException("No language were found in this ID",RitzConstants.ERROR_CODE);
			}
			else
			{
				checkform.setLanguage(new Language(checkincheckoutdto.getLanguage().getLid(), "", ""));
			}
		
		}
		else
		{
			
			throw new RitzkidsException("Language is mandatory", RitzConstants.ERROR_CODE);
		}
		
		
		if(checkincheckoutdto.getYoungGust()!=null)
		{
			ygo=ygr.findById(checkincheckoutdto.getYoungGust().getYoungGustId());
			if(!ygo.isPresent())
			{
				throw new RitzkidsException("No Young gust were found in given ID",RitzConstants.ERROR_CODE);
			}
			else
			{
				YoungGust yg=ygo.get();
				yg.setNickName(checkincheckoutdto.getNickName());
				yg.setLocation(checkincheckoutdto.getKidLocation());
				yg.setAgeGroup(checkincheckoutdto.getAgeGroup());
				yg.setLanguage(checkincheckoutdto.getLanguage().getName());
				ygr.save(yg);
				checkform.setYoungGust(yg);
			}
		}
		else
		{
			throw new RitzkidsException("Young gust data is mandatory",RitzConstants.ERROR_CODE);
		}
		
		
		//Save Checkin checkout form
		checkform.setCheckinStatus(true);
		cr.save(checkform);
		
		//saving medical details
		MedicalDetails md=  medicalDetailsMapper(checkincheckoutdto.getMedicalDetails());
		md.setCheckinCheckout(checkform);
		mr.save(md);
		
		
		//Mapping AuthorizedRelationDto to Authorized Relation
		if(checkincheckoutdto.getAutorizedRelation()!=null)
		{
			checkincheckoutdto.getAutorizedRelation().forEach(
				(a)->{
								AuthorizedRelation mappedRelation=authorizedRelationMapper(a);
						
								if(!(gr.findById(mappedRelation.getGuardian().getGuardianId())).isPresent())
									{
									//	throw new RitzkidsException("Guardian ID not found", RitzConstants.ERROR_CODE);
									}
								else
								{

									if(!rr.findById((mappedRelation.getRelationship().getRid())).isPresent())
									{
										//throw new RitzkidsException("Relationship ID not found", RitzConstants.ERROR_CODE);		
									}
									else
									{
										mappedRelation.setCheckinCheckout(checkform);
										ar.save(mappedRelation);
									}
						
								}
					
					}
				);
		
			
		}
		else
		{
			throw new RitzkidsException("Authorized pickup is mandatory ",RitzConstants.ERROR_CODE);
		}

		return checkform.getCheckinCheckoutId();
	}
	
	

	@Override
	public List<CheckInCheckOut> getAllCheckInCheckoutForm() throws RitzkidsException 
	{
		List<CheckInCheckOut> checkInCheckOuts=new ArrayList<CheckInCheckOut>();
		//cr.findAll().forEach(checkInCheckOuts::add);
		cr.findAllByOrderByCheckinCheckoutIdDesc().forEach(checkInCheckOuts::add);
		return checkInCheckOuts;
	}
	
	
	@Override
	public CheckInCheckOut getCheckInCheckoutForm(int cid) throws RitzkidsException 
	{
		if(!cr.findById(cid).isPresent())
		{
			throw new RitzkidsException("Invalid CheckinCheckout ID",RitzConstants.ERROR_CODE);
		}
		else
		{
			return cr.findById(cid).get();
		}
	}
	
	

	@Override
	public int updateCheckinCheckout(boolean status, int cid, int arid) throws RitzkidsException 
	{
		
		if(!cr.findById(cid).isPresent())
		{
			throw new RitzkidsException("Invalid CheckinCheckout ID",RitzConstants.ERROR_CODE);
		}
		else
		{
			Optional<CheckInCheckOut> cfo=cr.findById(cid);
			CheckInCheckOut cf=cfo.get();
			cf.setCheckinStatus(status);
			cf.setCheckinCheckoutId(cid);
			cf.setCheckinStatus(false);
			cr.save(cf);
			
			if(!ar.findById(arid).isPresent())
			{
				throw new RitzkidsException("Invalid Authorised ID",RitzConstants.ERROR_CODE);
			}
			else
			{
			
				Optional<AuthorizedRelation> aro=ar.findById(arid);
				AuthorizedRelation arelation=aro.get();
				arelation.setCheckedout(status);
				arelation.setAuthorizedRelationId(arid);
				ar.save(arelation);
				
			}
			
		}
		return 0;
	}
	
	
	

	private CheckInCheckOut checkincheckoutMapper(CheckInCheckOutDto cdto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(cdto,CheckInCheckOut.class);
	}
	
	private MedicalDetails medicalDetailsMapper(MedicalDetailsDto mdto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(mdto,MedicalDetails.class);
	}
	
	private AuthorizedRelation authorizedRelationMapper(AuthorizedRelationDto adto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(adto,AuthorizedRelation.class);
	}
	
}
