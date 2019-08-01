package com.rcg.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.YoungGust;

public interface YoungGustRepository extends CrudRepository<YoungGust, Integer>
{
	public Optional<YoungGust> getYoungGustByfolioID(long fid);	
	public List<YoungGust> getYoungGustBybookingID(long id);

	
}
