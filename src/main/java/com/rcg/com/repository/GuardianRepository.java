package com.rcg.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.Guardian;

public interface GuardianRepository extends CrudRepository<Guardian, Integer>
{
	public List<Guardian> getGuardianBybookingid(long bid);
	public Optional<Guardian> getGuardianByfolioid(long fid);

}
