package com.rcg.com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.MiddlewareToken;

public interface MiddleWareTokenRepository extends CrudRepository<MiddlewareToken, Integer> 
{
//	public Optional<MiddlewareToken> findTopByEmployeeEmployeeIdOrderByMiddlewareTokenIdDesc(int eid);

}
