package com.rcg.com.service;

import java.util.List;

import com.rcg.com.dao.Role;
import com.rcg.com.dto.RoleDto;
import com.rcg.com.exceptions.RitzkidsException;

public interface Role_Service 
{
	public int save(RoleDto r)throws RitzkidsException;
	public List<Role> getAllRole()throws RitzkidsException;
	public Role getrole(int rid)throws RitzkidsException;
	public int updateRole(int rid,RoleDto r)throws RitzkidsException;
	public String deleteRole(int rid)throws RitzkidsException;
	
}
