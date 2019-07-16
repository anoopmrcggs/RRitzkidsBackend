package com.rcg.com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.ConsentForm;

public interface ConCernFormRepository extends CrudRepository<ConsentForm,Integer>
{
	public Optional<ConsentForm> getConCernFormBylanguageLid(int language_id);
	
}
