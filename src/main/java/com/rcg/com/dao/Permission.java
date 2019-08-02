package com.rcg.com.dao;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ryg_permission")
public class Permission 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int permission_id;
	private String page;
	
	private int createdby;
	private Date created;
	
	private int updatedby;
	private Date updated;
	
	private boolean isactive;
	
	@ManyToMany(mappedBy = "permission")
	@JsonBackReference
	private Set<Role> roles; 

	public Permission() 
	{
		super();
	}

	public Permission(int permission_id, String page, int createdby, Date created, int updatedby, Date updated,
			boolean isactive) {
		super();
		this.permission_id = permission_id;
		this.page = page;
		this.createdby = createdby;
		this.created = created;
		this.updatedby = updatedby;
		this.updated = updated;
		this.isactive = isactive;
	}

	public Permission(int permission_id, String page) 
	{
		this.permission_id=permission_id;
		this.page=page;
	}

	public int getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(int permission_id) {
		this.permission_id = permission_id;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	


}
