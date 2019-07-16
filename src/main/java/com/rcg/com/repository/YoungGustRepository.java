package com.rcg.com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.YoungGust;

public interface YoungGustRepository extends CrudRepository<YoungGust, Integer>
{
	public Optional<YoungGust> getYoungGustByfolioid(long fid);
	
}
