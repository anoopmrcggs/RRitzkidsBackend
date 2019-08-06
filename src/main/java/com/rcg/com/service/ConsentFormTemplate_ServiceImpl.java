package com.rcg.com.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.rcg.com.dao.ConsentFormTemplate;
import com.rcg.com.dao.Language;
import com.rcg.com.dto.ConsentFormTemplateDto;
import com.rcg.com.dto.ConsentformTemplateWrapper;
import com.rcg.com.dto.SaveConsentFormDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.ConCernFormTemplateRepository;
import com.rcg.com.repository.LanguageRepository;
import com.rcg.com.util.RitzConstants;

@Service
public class ConsentFormTemplate_ServiceImpl implements ConsentFormTemplate_Service{

	@Autowired
	private ConCernFormTemplateRepository cr;
	
	@Autowired 
	private LanguageRepository lr;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	
	@Override
	public String saveConsentForm(ConsentformTemplateWrapper concernFormtemplateWrapperDto,int lid) throws RitzkidsException
	{		
		Optional<Language> language=lr.findById(lid);
		if(!language.isPresent())
		{
			throw new RitzkidsException("No language where found in this ID", RitzConstants.ERROR_CODE);
		}
		else
		{
			if(concernFormtemplateWrapperDto.getConsentFomTemplateDto()!=null)
				{
				concernFormtemplateWrapperDto.getConsentFomTemplateDto().forEach(
						
						(a)->
						{
							ConsentFormTemplate cf=formMapper(a);
							cf.setLanguage(new Language(lid, "", ""));
							cr.save(cf);
						}
						
						);
				}
			
		
			return "Operation Completed";
		}
	}

	@Override
	public List<ConsentFormTemplate> getConsentFormById(int lid) throws RitzkidsException 
	{	
		Optional<Language> language=lr.findById(lid);
		if(!language.isPresent())
		{
			throw new RitzkidsException("No language where found in this ID", RitzConstants.ERROR_CODE);
		}
		else
		{
			List<ConsentFormTemplate> concern=new ArrayList<ConsentFormTemplate>();
			cr.getAllConCernFormTemplateRepositoryBylanguageLid(lid).forEach(concern::add);
			return concern;
	
		}
	}

	@Override
	public List<ConsentFormTemplate> getAllConsentForm() 
	{
		List<ConsentFormTemplate> concern=new ArrayList<ConsentFormTemplate>();
		cr.findAll().forEach(concern::add);
		return concern;
	}

	@Override
	public String updateConsentForm(ConsentFormTemplateDto concernformdto, int cid,int lid)  throws RitzkidsException
	{
		Optional<Language> language=lr.findById(lid);		
		if(!language.isPresent())
		{
			throw new RitzkidsException("No language where found in gien ID", RitzConstants.ERROR_CODE);
		}
		else
		{
			Optional< ConsentFormTemplate> cf=cr.getConCernFormTemplateRepositoryBylanguageLid(lid);
			if(!cf.isPresent())
			{
				throw new RitzkidsException("No consentform where found in gien ID", RitzConstants.ERROR_CODE);

			}
			else
			{
				ConsentFormTemplate cform=formMapper(concernformdto);
				cform.setCfid(cid);
				cr.save(cform);
				return "Operation Completed";
			}

		}

		
	}

	@Override
	public String deleteConsentForm(int cid) throws RitzkidsException
	{
		
		Optional< ConsentFormTemplate> cf=cr.getConCernFormTemplateRepositoryBylanguageLid(cid);
		if(!cf.isPresent())
		{
			throw new RitzkidsException("No Consentformtemplate where found in given language ID", RitzConstants.ERROR_CODE);
		}
		else
		{
			cr.deleteById(cid);;
			return "Operation Completed";
		}
		
	}
	
	public boolean generatePDF(SaveConsentFormDto cdto) throws RitzkidsException
	{
		
		boolean status = false; 
		Context context=new Context(); 
		String fileName=cdto.getCheckinCheckoutId()+"_"+cdto.getYoungGusetFolioID()+"_"+cdto.getGuardianName().toUpperCase();
		File f=new File("");
		
		//change location local to server  when taking build
		
		//Server Location
		String fpath="/usr/lib/rcyc-app/consentform/"+fileName;
		
		//LocalLocation
		String[] floc=f.getAbsolutePath().split("/");
		String abPath=f.getAbsolutePath();
		String local=abPath.replace("/"+floc[(floc.length-1)], "/");
			   local=local+"genPdf/"+fileName;
		
		
		int[] numArr = {1};

		//Setting content
		cr.getAllConCernFormTemplateRepositoryBylanguageLid(cdto.getLanguageId()).forEach
		(
		(a)->{
			int i=numArr[0];
			context.setVariable("head"+i, a.getHead());
			context.setVariable("body"+i, a.getBoady());
			context.setVariable("item"+i, a.getItem());
			numArr[0]=numArr[0]+1;
		}
			
				
		);
		
		//Setting Signature
		context.setVariable("s1",cdto.getSignature1());
		context.setVariable("s2",cdto.getSignature2());
		context.setVariable("s3",cdto.getSignature3());
		context.setVariable("s4",cdto.getSignature4());
		context.setVariable("name",cdto.getSignedGuardian());

		
		String ht=templateEngine.process("consenttemplate", context); 
		
		
		try { 
				OutputStream os = new FileOutputStream(local); 
				PdfRendererBuilder builder = new
				PdfRendererBuilder(); builder.withHtmlContent(ht, "file:");
				builder.toStream(os); builder.run();
				status=true;
				
		}catch(Exception e) {e.printStackTrace();}
		
		return status;
	}
	

	
	private ConsentFormTemplate formMapper(ConsentFormTemplateDto fdto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(fdto, ConsentFormTemplate.class);
	}
}
