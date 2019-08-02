package com.rcg.com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.AuthorizedRelation;
import com.rcg.com.exceptions.RitzkidsException;

public interface AuthorizedRelationRepository extends CrudRepository<AuthorizedRelation, Integer> 
{
	public List<AuthorizedRelation> getAuthorizedRelationsBycheckinCheckoutCheckinCheckoutId(int cid) throws RitzkidsException;
}
