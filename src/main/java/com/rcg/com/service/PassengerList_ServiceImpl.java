package com.rcg.com.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.Guardian;
import com.rcg.com.dao.YoungGust;
import com.rcg.com.dto.PassengerListDto;
import com.rcg.com.dto.PassengerListWrapper;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.GuardianRepository;
import com.rcg.com.repository.YoungGustRepository;
import com.rcg.com.util.RitzConstants;

@Service
public class PassengerList_ServiceImpl implements PassengerList_Service 
{
	@Autowired
	private GuardianRepository gr;
	
	@Autowired
	private YoungGustRepository yr;
	
	  


	@Override
	public String savePassenger(PassengerListWrapper p) throws RitzkidsException
	{

		if(p.getPassengerWrapper()!=null)
		{
			List<PassengerListDto> pl=p.getPassengerWrapper();

			  pl.forEach(a-> 
			  { 
				  if(String.valueOf(a.getPassengertype()).equals("A"))
				  {
					  Guardian g=guardianMapper(a);
					  //gr.getGuardianByfolioid(g.getFolioid());
					  if(!gr.getGuardianByfolioid(g.getFolioid()).isPresent())
					  {
						  gr.save(g);						
						  System.out.println("Guardian Saved");

					  }
				  }
				  else
				  {
					    YoungGust y=youngGustMapper(a);
					    
					    if(!yr.getYoungGustByfolioid(y.getFolioid()).isPresent())
					    {
					    	 yr.save(y);
							 List<Guardian> gl=gr.getGuardianBybookingid(y.getBookingid());
							 if(gl!=null)
							    {
								 	YoungGust yg=yr.getYoungGustByfolioid(y.getFolioid()).get();
							    	for(Guardian g:gl)
							    	{
							    
							    			if(g.getYoung_gust()!=null)
							    			{
							    				g.getYoung_gust().add(new YoungGust(yg.getYounggust_id())); 
							    				
							    			}
							    			else
							    			{
							    				Set<YoungGust> young_gust=new HashSet<YoungGust>();
							    				young_gust.add(yg);
							    				g.setYoung_gust(young_gust);
							    			}
							    			gr.save(g);
								
							    	}
									
							    }
					    }
					   
				  }
			  });
		}
		else
		{
			System.out.println("No data were found!!");
		}
		
		  
		 
		
		return "success";
	}
	
	@Override
	public List<Guardian> getAllGuardian() throws RitzkidsException 
	{
		List<Guardian> g=new ArrayList<Guardian>();
		gr.findAll().forEach(g::add);
		return g;
	}
	
	
	private Guardian guardianMapper(PassengerListDto pdto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(pdto,Guardian.class);
	}
	
	private YoungGust youngGustMapper(PassengerListDto pdto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(pdto,YoungGust.class);
	}
	
}
