package com.rcg.com.dto;

import java.util.Date;
import java.util.Set;
import javax.persistence.ManyToMany;


public class RoleDto 
{
	private int roleId;
	private String name;
	private int createdby;
	private Date created;
	private int updatedby;
	private Date updated;
	private boolean isactive;

	@ManyToMany
	private Set<PermissionDto> permission;

	
	

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(int updatedby) {
		this.updatedby = updatedby;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public Set<PermissionDto> getPermission() {
		return permission;
	}

	public void setPermission(Set<PermissionDto> permission) {
		this.permission = permission;
	}
	
	
	


}
