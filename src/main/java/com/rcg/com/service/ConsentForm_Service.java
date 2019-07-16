package com.rcg.com.service;

import java.util.List;

import com.rcg.com.dao.ConsentForm;
import com.rcg.com.dao.Language;
import com.rcg.com.dto.ConsentFormDto;
import com.rcg.com.dto.LanguageDto;
import com.rcg.com.exceptions.ConstraintsException;
import com.rcg.com.exceptions.RitzkidsException;

public interface ConsentForm_Service 
{
		//Save Concernform
		public String saveConsentForm(ConsentFormDto consentformdto,int lid)throws RitzkidsException;
		//Get Concernform by ID
		public ConsentForm getConsentFormById(int cid)throws RitzkidsException;
		//Get All Concernform
		public List<ConsentForm> getAllConsentForm();
		//Update Concernform
		public String updateConsentForm(ConsentFormDto consentformdto,int cid,int lid) throws RitzkidsException,ConstraintsException;
		//Delete Concernform
		public String deleteConsentForm(int cid) throws RitzkidsException;
}
