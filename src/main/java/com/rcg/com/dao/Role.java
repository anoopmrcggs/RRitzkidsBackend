package com.rcg.com.dao;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;
	
	private String name;
	
	@Column(name="created_by")
	private int createdBy;
	
	private Date created;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	private Date updated;
	
	@Column(name="is_active")
	private Boolean isActive;

	@ManyToMany
	private Set<Permission> permission;

	public Role() 
	{
		super();
	}


	public Role(int roleId) {
		super();
		this.roleId = roleId;
	}



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

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<Permission> getPermission() {
		return permission;
	}

	public void setPermission(Set<Permission> permission) {
		this.permission = permission;
	}
	
}
