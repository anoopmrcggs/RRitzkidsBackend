package com.rcg.com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.Employee;
import com.rcg.com.dao.MiddlewareToken;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.MiddleWareTokenRepository;
import com.rcg.com.util.RitzConstants;

@Service
public class MiddleWareToken_ServiceImpl implements MiddleWareToken_Service 
{

	
	@Autowired
	private MiddleWareTokenRepository mtr;
	
	
	//Saving a token
	@Override
	public String saveToken(String token,int eid) throws RitzkidsException 
	{
		MiddlewareToken mToken=new MiddlewareToken(token,new Employee(eid));
		mtr.save(mToken);
		return mToken.getToken();
	}
	
	
//getting a latest token by employee id 
	/*
	 * @Override public String getToken(int eid) throws RitzkidsException {
	 * Optional<MiddlewareToken>
	 * mTokenO=mtr.findTopByEmployeeEmployeeIdOrderByMiddlewareTokenIdDesc(eid);
	 * 
	 * if(!mTokenO.isPresent()) { throw new
	 * RitzkidsException("No token were found for this employee",
	 * RitzConstants.ERROR_CODE); } else { return mTokenO.get().getToken(); } }
	 */

}
