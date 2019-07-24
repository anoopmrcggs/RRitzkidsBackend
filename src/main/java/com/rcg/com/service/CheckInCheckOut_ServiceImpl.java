package com.rcg.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.AuthorizedRelation;
import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dao.Guardian;
import com.rcg.com.dao.Language;
import com.rcg.com.dao.MedicalDetails;
import com.rcg.com.dao.YoungGust;
import com.rcg.com.dao.YoungGustNotes;
import com.rcg.com.dto.AuthorizedRelationDto;
import com.rcg.com.dto.CheckInCheckOutDto;
import com.rcg.com.dto.GuardianDto;
import com.rcg.com.dto.MedicalDetailsDto;
import com.rcg.com.dto.YoungGustNotesDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.AuthorizedRelationRepository;
import com.rcg.com.repository.CheckInCheckOutRepository;
import com.rcg.com.repository.GuardianRepository;
import com.rcg.com.repository.LanguageRepository;
import com.rcg.com.repository.MedicalDetailsRepository;
import com.rcg.com.repository.RelationshipRepository;
import com.rcg.com.repository.YoungGustNotesRepository;
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
	private YoungGustNotesRepository yr; 
	
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
		//CheckinCheckoutFormMapping
		CheckInCheckOut checkform=checkincheckoutMapper(checkincheckoutdto);
		if(!lr.findById(checkincheckoutdto.getLanguage().getLid()).isPresent())
		{
			throw new RitzkidsException("No language were found in this ID",RitzConstants.ERROR_CODE);
		}
		else
		{
			checkform.setLanguage(new Language(checkincheckoutdto.getLanguage().getLid(), "", ""));
		}
		Optional<YoungGust> ygo=ygr.findById(checkincheckoutdto.getYoungGust().getYoungGustId());
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

		/*
		 * Set<AuthorizedRelationDto> ars=checkincheckoutdto.getAutorizedRelation();
		 * ars.forEach(
		 * 
		 * (a)-> { Optional<Guardian> go=gr.findById(a.getGuardian().getGuardianId());
		 * if(go.isPresent()) { Guardian g=go.get();
		 * //g.setContectNumber(a.getContactNumber()); gr.save(g); }
		 * 
		 * 
		 * }
		 * 
		 * );
		 */
		
		checkform.setCheckinStatus(true);
		cr.save(checkform);
		
		
		MedicalDetails md=  medicalDetailsMapper(checkincheckoutdto.getMedicalDetails());
		md.setCheckinCheckout(checkform);
		mr.save(md);
		
		/*
		 * //Mapping MedicalDetailsDto to medical Details
		 * checkincheckoutdto.getMedicalDetails().forEach( (a)->{ MedicalDetails
		 * m=medicalDetailsMapper(a); m.setCheckinCheckout(checkform); mr.save(m);
		 * 
		 * } );
		 */
		 

		/*
		 * //Mapping YoungGustDto to YoungGust
		 * checkincheckoutdto.getYounggustnotesDto().forEach( (a)->{
		 * 
		 * YoungGustNotes yn=youngGustNotesMapper(a); yn.setCheckinCheckout(checkform);
		 * yr.save(yn); } );
		 */
		
		//Mapping AuthorizedRelationDto to Authorized Relation
		if(checkincheckoutdto.getAutorizedRelation()!=null)
		{
		checkincheckoutdto.getAutorizedRelation().forEach(
				(a)->{
						AuthorizedRelation mappedRelation=authorizedRelationMapper(a);
						if(!(gr.findById(mappedRelation.getGuardian().getGuardianId())).isPresent())
						{
							System.out.println("Guardian ID not found");
						}
						else
						{
							if(!rr.findById((mappedRelation.getRelationship().getRid())).isPresent())
							{
								System.out.println("Relation ID not found");

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
			throw new RitzkidsException("Authorized pickup data should be there ",RitzConstants.ERROR_CODE);
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
	
	private YoungGustNotes youngGustNotesMapper(YoungGustNotesDto ydto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(ydto,YoungGustNotes.class);
	}
	
	private AuthorizedRelation authorizedRelationMapper(AuthorizedRelationDto adto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(adto,AuthorizedRelation.class);
	}
	
}
