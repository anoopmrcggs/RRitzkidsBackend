package com.rcg.com.dto;

public class SaveConsentFormDto 
{
	private int languageId;
	
	private int checkinCheckoutId;
	
	private String signature1;
	private String signature2;
	private String signature3;
	private String guardianName;
	
	public int getLanguageId() 
	{
		return languageId;
	}
	
	public void setLanguageId(int languageId) 
	{
		this.languageId = languageId;
	}
	
	public int getCheckinCheckoutId() 
	{
		return checkinCheckoutId;
	}

	public void setCheckinCheckoutId(int checkinCheckoutId) 
	{
		this.checkinCheckoutId = checkinCheckoutId;
	}

	public String getSignature1() 
	{
		return signature1;
	}
	
	public void setSignature1(String signature1) 
	{
		this.signature1 = signature1;
	}
	
	public String getSignature2() 
	{
		return signature2;
	}
	
	public void setSignature2(String signature2) 
	{
		this.signature2 = signature2;
	}
	
	public String getSignature3() 
	{
		return signature3;
	}
	
	public void setSignature3(String signature3) 
	{
		this.signature3 = signature3;
	}
	
	public String getGuardianName() 
	{
		return guardianName;
	}
	
	public void setGuardianName(String guardianName)
	{
		this.guardianName = guardianName;
	}
	
}
