package com.rcg.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.ConsentForm;
import com.rcg.com.dao.ConsentFormTemplate;

public interface ConCernFormTemplateRepository extends CrudRepository<ConsentFormTemplate,Integer>
{
	public Optional<ConsentFormTemplate> getConCernFormTemplateRepositoryBylanguageLid(int language_id);
	public List<ConsentFormTemplate> getAllConCernFormTemplateRepositoryBylanguageLid(int language_id);
	
}
