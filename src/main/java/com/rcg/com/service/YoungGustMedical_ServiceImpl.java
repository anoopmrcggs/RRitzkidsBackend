package com.rcg.com.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dao.MedicalDetails;
import com.rcg.com.dto.MedicalDetailsDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.MedicalDetailsRepository;

@Service
public class YoungGustMedical_ServiceImpl implements YoungGustMedical_Service 
{
	@Autowired
	private MedicalDetailsRepository mdr;
	
	@Override
	public void save(MedicalDetailsDto mdto,int cid) throws RitzkidsException 
	{
		MedicalDetails md=medicalDetailsMapper(mdto);
		md.setCheckinCheckout(new CheckInCheckOut(cid));
		mdr.save(md);
	}

	@Override
	public void update(MedicalDetailsDto mdto, int mid, int cid) throws RitzkidsException 
	{
		MedicalDetails md=medicalDetailsMapper(mdto);
		md.setCheckinCheckout(new CheckInCheckOut(cid));
		md.setMedicalDetailsId(mid);
		mdr.save(md);

	}

	private MedicalDetails medicalDetailsMapper(MedicalDetailsDto mdto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(mdto,MedicalDetails.class);
		
	}
}
