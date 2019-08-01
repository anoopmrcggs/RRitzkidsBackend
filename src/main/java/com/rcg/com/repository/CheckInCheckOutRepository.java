package com.rcg.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.CheckInCheckOut;

public interface CheckInCheckOutRepository extends CrudRepository<CheckInCheckOut, Integer> 
{
	public List<CheckInCheckOut>  findAllByOrderByCheckinCheckoutIdAsc();
	public List<CheckInCheckOut>  findAllByOrderByCheckinCheckoutIdDesc();
	public Optional<CheckInCheckOut> findTopByyoungGustYoungGustIdOrderByCheckinCheckoutIdDesc(int yid);
	
}
