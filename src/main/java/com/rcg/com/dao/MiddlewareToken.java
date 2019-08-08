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
@Table(name="middleware_token")
public class MiddlewareToken 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="token_id")
	private int tokenId;
	
	private String token;
	
	@ManyToOne
	private Employee employee;
	
	private Date created;
	
	
	

	public MiddlewareToken(String token, Employee employee) 
	{
		super();
		this.token = token;
		this.employee = employee;
	}

	public int getTokenId() 
	{
		return tokenId;
	}

	public void setTokenId(int tokenId) 
	{
		this.tokenId = tokenId;
	}

	public String getToken() 
	{
		return token;
	}

	public void setToken(String token) 
	{
		this.token = token;
	}

	public Employee getEmployee() 
	{
		return employee;
	}

	public void setEmployee(Employee employee) 
	{
		this.employee = employee;
	}

	public Date getCreated() 
	{
		return created;
	}

	public void setCreated(Date created) 
	{
		this.created = created;
	}
	
}
