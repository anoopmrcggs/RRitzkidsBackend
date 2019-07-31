package com.rcg.com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.MedicalDetails;
import com.rcg.com.exceptions.RitzkidsException;

public interface MedicalDetailsRepository extends CrudRepository<MedicalDetails,Integer>
{
	public Optional<MedicalDetails> getMedicalDetailsBycheckinCheckoutCheckinCheckoutId(int cid)throws RitzkidsException; 
}
