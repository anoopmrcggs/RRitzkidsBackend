package com.rcg.com.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.Role;
import com.rcg.com.dto.RoleDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.RoleRepository;

@Service
public class Role_ServiceImpl implements Role_Service 
{
	@Autowired
	private RoleRepository rr;
	
	private int createdby=100;
	private int updatedby=100;
	private Calendar calender=Calendar.getInstance();
	
	@Override
	public int save(RoleDto r) throws RitzkidsException
	{
		Role role=roleMapper(r);
		role.setCreated(calender.getTime());
		role.setUpdated(calender.getTime());
		role.setCreatedby(createdby);
		role.setUpdatedby(updatedby);
		rr.save(role);
		return role.getRole_id();
	}

	@Override
	public List<Role> getAllRole() throws RitzkidsException
	{
		List<Role> role=new ArrayList<Role>();
		rr.findAll().forEach(role::add);
		return role;
	}

	@Override
	public Role getrole(int rid) throws RitzkidsException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateRole(int rid, RoleDto r) throws RitzkidsException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String deleteRole(int rid) throws RitzkidsException
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	private Role roleMapper(RoleDto r) throws RitzkidsException
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(r,Role.class);
	}

}
