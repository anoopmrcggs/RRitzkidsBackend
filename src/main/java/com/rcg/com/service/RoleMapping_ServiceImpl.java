package com.rcg.com.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.Permission;
import com.rcg.com.dao.Role;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.PermissionRepository;
import com.rcg.com.repository.RoleRepository;
import com.rcg.com.util.RitzConstants;

@Service
public class RoleMapping_ServiceImpl implements RoleMapping_Service 
{
	
	@Autowired
	private RoleRepository rr;

	@Autowired
	private PermissionRepository pr;
	
	@Override
	public void rolePermissionMapping(int rid, int pid) throws RitzkidsException 
	{
		Optional<Permission> permission=pr.findById(pid);
		Optional<Role> role=rr.findById(rid);
		
		if(permission.isPresent())
		{
			if(role.isPresent())
			{
				Role r=role.get();
				r.getPermission().add(new Permission(pid, ""));
				rr.save(r);
				
				Permission p=permission.get();
				p.getRoles().add(new Role(rid));
				pr.save(p);
			}
			else
			{
				throw new RitzkidsException("Role ID is not Valid", RitzConstants.ERROR_CODE);
			}
		}
		else
		{
			throw new RitzkidsException("Permission ID is not Valid", RitzConstants.ERROR_CODE);
		}


	}

}
