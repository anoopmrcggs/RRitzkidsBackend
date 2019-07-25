package com.rcg.com.dao;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ryg_role")
public class Role 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_id;
	private String name;
	private int createdby;
	private Date created;
	private int updatedby;
	private Date updated;
	private boolean isactive;

	@ManyToMany//(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	/*
	 * @JoinTable(name = "ryg_role_permission", joinColumns
	 * = @JoinColumn(name="role_id",referencedColumnName = "role_id"),
	 * inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName
	 * = "permission_id"))
	 */
	private Set<Permission> permission;

	public Role() 
	{
		super();
	}
	
	public Role(int role_id) 
	{
		this.role_id = role_id;
	}

	public Role(int role_id, String name, int createdby, Date created, int updatedby, Date updated, boolean isactive,
			Set<Permission> permission) {
		super();
		this.role_id = role_id;
		this.name = name;
		this.createdby = createdby;
		this.created = created;
		this.updatedby = updatedby;
		this.updated = updated;
		this.isactive = isactive;
		this.permission = permission;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
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

	public Set<Permission> getPermission() {
		return permission;
	}

	public void setPermission(Set<Permission> permission) {
		this.permission = permission;
	}
	
	
	


}
