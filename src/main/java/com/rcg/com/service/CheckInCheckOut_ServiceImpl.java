package com.rcg.com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import com.rcg.com.dto.CheckInCheckOutStatsUpdationDto;
import com.rcg.com.dto.MedicalDetailsDto;
import com.rcg.com.dto.YoungGustCheckinStatusDto;
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
		
		//Adding Young gust
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
				yg.setAgeGroup(checkincheckoutdto.getAgeGroup());
				yg.setLanguage(checkincheckoutdto.getLanguage().getName());
				yg.setCreated(new Date());
				yg.setCreatedBy(checkincheckoutdto.getCreatedBy());
				yg.setUpdated(new Date());
				yg.setUpdatedBy(checkincheckoutdto.getCreatedBy());
				ygr.save(yg);
				checkform.setYoungGust(yg);
			}
		}
		else
		{
			throw new RitzkidsException("Young gust data is mandatory",RitzConstants.ERROR_CODE);
		}
		
		
		//Save Checkin checkout form
		checkform.setCreated(new Date());
		checkform.setUpdated(new Date());
		checkform.setCreatedBy(checkincheckoutdto.getCreatedBy());
		checkform.setUpdatedBy(checkincheckoutdto.getCreatedBy());
		checkform.setEntryTime(new Date());
		checkform.setCheckinStatus(true);
		cr.save(checkform);
		
		//saving medical details
		MedicalDetails md=  medicalDetailsMapper(checkincheckoutdto.getMedicalDetails());
		md.setCheckinCheckout(checkform);
		md.setCreated(new Date());
		md.setUpdated(new Date());
		md.setCreatedBy(checkincheckoutdto.getCreatedBy());
		md.setUpdatedBy(checkincheckoutdto.getCreatedBy());
		mr.save(md);
		
		
		//Mapping AuthorizedRelationDto to Authorized Relation
		if(checkincheckoutdto.getAutorizedRelation()!=null)
		{
			
			Iterator<AuthorizedRelationDto> itr=checkincheckoutdto.getAutorizedRelation().iterator();
			while(itr.hasNext())
			{
				AuthorizedRelation mappedRelation=authorizedRelationMapper(itr.next());
				if(!(gr.findById(mappedRelation.getGuardian().getGuardianId())).isPresent())
				{
					throw new RitzkidsException("Guardian ID not found", RitzConstants.ERROR_CODE);		
				}
				else
				{
					if(!rr.findById((mappedRelation.getRelationship().getRid())).isPresent())
					{
						throw new RitzkidsException("Relationship ID not found", RitzConstants.ERROR_CODE);		
					}
					else
					{
						mappedRelation.setCreated(new Date());
						mappedRelation.setUpdated(new Date());
						mappedRelation.setCreatedBy(checkincheckoutdto.getCreatedBy());
						mappedRelation.setUpdatedBy(checkincheckoutdto.getCreatedBy());
						
						mappedRelation.setCheckinCheckout(checkform);
						ar.save(mappedRelation);
					}
				}
			}
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
	public int updateCheckinCheckout(CheckInCheckOutStatsUpdationDto cdto) throws RitzkidsException 
	{
		
		if(!cr.findById(cdto.getCheckinID()).isPresent())
		{
			throw new RitzkidsException("Invalid CheckinCheckout ID",RitzConstants.ERROR_CODE);
		}
		else
		{
			
			Optional<CheckInCheckOut> cfo=cr.findById(cdto.getCheckinID());
			CheckInCheckOut cf=cfo.get();
			if(cf.isSelfCheckout())
			{
				cf.setUpdated(new Date());
				cf.setUpdatedBy(cdto.getUpdatedBy());
				cf.setCheckinStatus(cdto.getStatus());
				cf.setExitTime(new Date());
				cr.save(cf);
			}
			else
			{
				cf.setCheckinStatus(cdto.getStatus());
				cf.setCheckinCheckoutId(cdto.getCheckinID());
				cf.setCheckinStatus(false);
				cf.setUpdated(new Date());
				cf.setUpdatedBy(cdto.getUpdatedBy());
				cf.setExitTime(new Date());
				cr.save(cf);
	
				  if(!ar.findById(cdto.getAuthorizedID()).isPresent()) 
				  { 
					  throw new RitzkidsException("Invalid Authorised ID",RitzConstants.ERROR_CODE); 
				  } 
				  else 
				  {
				  
				  Optional<AuthorizedRelation> aro=ar.findById(cdto.getAuthorizedID()); AuthorizedRelation
				  arelation=aro.get(); arelation.setCheckedout(cdto.getStatus());
				  arelation.setAuthorizedRelationId(cdto.getAuthorizedID()); 
				  arelation.setUpdated(new Date());
				  arelation.setUpdatedBy(cdto.getUpdatedBy());
				  ar.save(arelation);
				  
				  }
			}
		}
			 
		return 0;
	}
	
	
	
	

	@Deprecated
	@Override
	public int updateCheckinCheckoutStatus(boolean status, int cid, int arid) throws RitzkidsException 
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
			cf.setUpdated(new Date());
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
				arelation.setUpdated(new Date());
				ar.save(arelation);
				
			}
			
		}
		return 0;
	}
	
	
	
	
	
	

	@Override
	public int updateCheckinCheckout(CheckInCheckOutDto cdto,int cid) throws RitzkidsException 
	{
		CheckInCheckOut ck=checkincheckoutMapper(cdto);
		ck.setCheckinCheckoutId(cid);
		if(!cr.findById(cid).isPresent())
		{
			throw new RitzkidsException("Invalid Checkin Checkout ID",RitzConstants.ERROR_CODE);
		}
		else
		{
			//Updating Authorized details
			Set<AuthorizedRelation> ars=ck.getAutorizedRelation();
			Iterator<AuthorizedRelation> itr=ars.iterator(); 
			
			AuthorizedRelation aro;
			while(itr.hasNext()) 
			{ 
				aro=itr.next();
				aro.setCheckinCheckout(ck);
				aro.setUpdated(new Date());
				ar.save(aro);
				
			}
			
			Optional<YoungGust> ygo=ygr.findById(cdto.getYoungGust().getYoungGustId());
			if(!ygo.isPresent())
			{
				throw new RitzkidsException("No Young gust were found in given ID",RitzConstants.ERROR_CODE);
			}
			else
			{
				YoungGust yg=ygo.get();
				yg.setNickName(cdto.getNickName());
				yg.setAgeGroup(cdto.getAgeGroup());
				ygr.save(yg);
			
			}
			
			
			
			if(ck.getMedicalDetails()!=null)
			{
				if(!(mr.getMedicalDetailsBycheckinCheckoutCheckinCheckoutId(cid)).isPresent())
				{
					throw new RitzkidsException("Medical details ID not valid",RitzConstants.ERROR_CODE);
				}
				else
				{
					int md_id=mr.getMedicalDetailsBycheckinCheckoutCheckinCheckoutId(cid).get().getMedicalDetailsId();
					MedicalDetails md=ck.getMedicalDetails();
					md.setMedicalDetailsId(md_id);
					md.setCheckinCheckout(ck);
					md.setUpdated(new Date());
					md.setCreatedBy(cdto.getCreatedBy());
					md.setUpdatedBy(cdto.getCreatedBy());
					mr.save(md);
				}
			}
			else
			{
				throw new RitzkidsException("Medical details not found",RitzConstants.ERROR_CODE);
			}
			
		}
		ck.setCheckinStatus(true);
		ck.setUpdated(new Date());
		ck.setUpdatedBy(cdto.getUpdatedBy());
		cr.save(ck);
		return 0;
	}


	@Override
	public YoungGustCheckinStatusDto getCheckinCheckoutStatus(int fid) throws RitzkidsException 
	{
	
		Optional<YoungGust> yg=ygr.getYoungGustByfolioID(fid);
		
		if(!yg.isPresent())
		{
			throw new RitzkidsException("No young guest were found in this ID : "+fid,RitzConstants.ERROR_CODE);
		}
		else
		{
			YoungGustCheckinStatusDto ycdto=new YoungGustCheckinStatusDto();
			Optional<CheckInCheckOut> ck=cr.findTopByyoungGustYoungGustIdOrderByCheckinCheckoutIdDesc(yg.get().getYoungGustId());
			if(ck.isPresent())
			{
				ycdto.setCheckinID(ck.get().getCheckinCheckoutId());
				ycdto.setFolioID(ck.get().getYoungGust().getFolioID());
				ycdto.setStatus(ck.get().isCheckinStatus());
				return ycdto;
			}
			else
			{
				ycdto.setCheckinID(0);
				ycdto.setFolioID(fid);
				ycdto.setStatus(false);
				return ycdto;
			}
		}
		 
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
