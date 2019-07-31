package com.rcg.com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.Login;
import com.rcg.com.exceptions.RitzkidsException;

public interface LoginRepository extends CrudRepository<Login,Integer>
{
	public Optional<Login> getLoginByusername(String userName) throws RitzkidsException;
	public Optional<Login> getLoginByemployeeEmployeeId(int eid) throws RitzkidsException;

}
