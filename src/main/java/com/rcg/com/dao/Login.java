package com.rcg.com.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "ryg_login")
public class Login 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="login_id")
	private int loginId;
	
	@ManyToOne
	private Employee employee;
	private String username;
	private String password;
	
	@Column(name="created_by")
	private int cretedBy;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	private Date created;
	private Date updated;
	
	@Column(name="is_active")
	private Boolean isActive;

	
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


	public int getCretedBy() {
		return cretedBy;
	}

	public void setCretedBy(int cretedBy) {
		this.cretedBy = cretedBy;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
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

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	
	
}
