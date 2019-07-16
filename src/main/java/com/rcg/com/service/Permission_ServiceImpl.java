package com.rcg.com.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.Permission;
import com.rcg.com.dao.Role;
import com.rcg.com.dto.PermissionDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.PermissionRepository;

@Service
public class Permission_ServiceImpl implements Permission_Service 
{
	@Autowired
	private PermissionRepository pr;

	
	private int createdby=100;
	private int updatedby=100;
	private Calendar calender=Calendar.getInstance();
	
	
	@Override
	public int save(PermissionDto p)throws RitzkidsException 
	{
		Permission permission=permissionMapper(p);
		permission.setCreated(calender.getTime());
		permission.setUpdated(calender.getTime());
		permission.setCreatedby(createdby);
		permission.setUpdatedby(updatedby);
		pr.save(permission);
		return permission.getPermission_id();
	}

	@Override
	public List<Permission> getAllPermission() throws RitzkidsException
	{
		List<Permission> p=new ArrayList<Permission>();
		pr.findAll().forEach(p::add);
		return p;
	}

	@Override
	public Role getpermission(int pid) throws RitzkidsException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePermission(int pid, PermissionDto p) throws RitzkidsException 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String deletePermission(int pid) throws RitzkidsException
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	private Permission permissionMapper(PermissionDto p)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(p,Permission.class);
	}

}
