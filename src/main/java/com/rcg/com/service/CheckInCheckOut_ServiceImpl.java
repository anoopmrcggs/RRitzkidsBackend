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
import com.rcg.com.dao.YoungGustNotes;
import com.rcg.com.dto.AuthorizedRelationDto;
import com.rcg.com.dto.CheckInCheckOutDto;
import com.rcg.com.dto.MedicalDetailsDto;
import com.rcg.com.dto.YoungGustNotesDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.AuthorizedRelationRepository;
import com.rcg.com.repository.CheckInCheckOutRepository;
import com.rcg.com.repository.LanguageRepository;
import com.rcg.com.repository.MedicalDetailsRepository;
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
	private LanguageRepository lr;

	
	//Saving Checkin checkout form
	
	@Override
	public int saveCheckInCheckoutForm(CheckInCheckOutDto checkincheckoutdto ) throws RitzkidsException 
	{
		
		//CheckinCheckoutFormMapping
		CheckInCheckOut checkform=checkincheckoutMapper(checkincheckoutdto);
		if(!lr.findById(checkincheckoutdto.getLanguagedto().getLid()).isPresent())
		{
			throw new RitzkidsException("No language were found in this ID",RitzConstants.ERROR_CODE);
		}
		else
		{
			checkform.setLanguage(new Language(checkincheckoutdto.getLanguagedto().getLid(), "", ""));
		}
		Optional<YoungGust> ygo=ygr.findById(checkincheckoutdto.getYounggustdto().getYoungGustId());
		if(!ygo.isPresent())
		{
			throw new RitzkidsException("no Young gust were found in given ID",RitzConstants.ERROR_CODE);
		}
		else
		{
			YoungGust yg=ygo.get();
			yg.setNickName(checkincheckoutdto.getNicname());
			ygr.save(yg);
			checkform.setYounggust(yg);
		}
		
		cr.save(checkform);
		
		
		//Mapping MedicalDetailsDto to medical Details
		checkincheckoutdto.getMedicaldetailsDto().forEach(
					(a)->{
							MedicalDetails m=medicalDetailsMapper(a);
							m.setCheckinCheckout(checkform);
							mr.save(m);

						}
					);

		//Mapping YoungGustDto to YoungGust
		checkincheckoutdto.getYounggustnotesDto().forEach(
				(a)->{

						YoungGustNotes yn=youngGustNotesMapper(a);
						yn.setCheckinCheckout(checkform);
						yr.save(yn);						
					}
				);
		
		//Mapping AuthorizedRelationDto to Authorized Relation
		checkincheckoutdto.getAutorized_relationDto().forEach(
				(a)->{
						AuthorizedRelation mappedRelation=authorizedRelationMapper(a);
						mappedRelation.setCheckinCheckout(checkform);
						ar.save(mappedRelation);
					}
				);

		return 0;
	}

	@Override
	public List<CheckInCheckOut> getAllCheckInCheckoutForm() throws RitzkidsException 
	{
		List<CheckInCheckOut> checkInCheckOuts=new ArrayList<CheckInCheckOut>();
		cr.findAll().forEach(checkInCheckOuts::add);
		return checkInCheckOuts;
	}

	@Override
	public Optional<CheckInCheckOut> getCheckInCheckoutForm(int cid) throws RitzkidsException 
	{
		// TODO Auto-generated method stub
		return null;
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
