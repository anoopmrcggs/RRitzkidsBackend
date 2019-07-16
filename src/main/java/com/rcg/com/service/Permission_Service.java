package com.rcg.com.service;

import java.util.List;

import com.rcg.com.dao.Permission;
import com.rcg.com.dao.Role;
import com.rcg.com.dto.PermissionDto;
import com.rcg.com.exceptions.RitzkidsException;

public interface Permission_Service 
{
	public int save(PermissionDto p) throws RitzkidsException;;
	public List<Permission> getAllPermission() throws RitzkidsException;;
	public Role getpermission(int pid)throws RitzkidsException;;
	public int updatePermission(int pid,PermissionDto p) throws RitzkidsException;;
	public String deletePermission(int pid) throws RitzkidsException;;
}
