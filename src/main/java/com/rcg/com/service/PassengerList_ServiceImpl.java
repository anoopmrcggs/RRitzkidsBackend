package com.rcg.com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
	
	  

	//Save Passenger List into Guardian and Youngest tables
	@Override
	public long savePassenger(PassengerListWrapper p) throws RitzkidsException
	{
		long bookingId;
		long bid[]=new long[1];
		if(p.getPassengerWrapper()!=null)
		{
			List<PassengerListDto> pl=p.getPassengerWrapper();

			  pl.forEach(a-> 
			  { //Check if Passenger is a adult type 
				  if(String.valueOf(a.getPassengerType()).equals("A"))
				  {
					  Guardian g=guardianMapper(a);
					  //Check Whether Guardian Existing or not
					  if(!gr.getGuardianByfolioID(g.getFolioID()).isPresent())
					  {
						  //getting all kid already registered on the given booking number
						  List<YoungGust> ygl=yr.getYoungGustBybookingID(g.getBookingID());
						  //if Kid found in same booking number
						  if(ygl.size()>0)
						  {
							  for(YoungGust young:ygl)
							  {
								Set<YoungGust> youngGustSet=new HashSet<YoungGust>();
								youngGustSet.add(young); 
								g.setYoungGust(youngGustSet);
							  }
							 
						  }
						  g.setCreated(new Date());
						  g.setUpdated(new Date());
						  gr.save(g);

					  }
					  
					bid[0]=g.getBookingID(); 
					  
				  }
				  else
				  {
					    YoungGust y=youngGustMapper(a);
					    //check kid already existing or not
					    if(!yr.getYoungGustByfolioID(y.getFolioID()).isPresent())
					    {
					    	 yr.save(y);					    	 
							//getting all guarding have same booking number
					    	 List<Guardian> gl=gr.getGuardianBybookingID(y.getBookingID());
							
					    	 if(gl!=null)
							    {
								 	YoungGust yg=yr.getYoungGustByfolioID(y.getFolioID()).get();
							    	for(Guardian g:gl)
							    	{
							    			//if there is any young guest already there
							    			if(g.getYoungGust()!=null)
							    			{
							    				g.getYoungGust().add(new YoungGust(yg.getYoungGustId())); 
							    				
							    			}
							    			else //empty young guest
							    			{
							    				Set<YoungGust> young_gust=new HashSet<YoungGust>();
							    				young_gust.add(yg);
							    				g.setYoungGust(young_gust);
							    			}
							    			g.setCreated(new Date());
							    			g.setUpdated(new Date());
							    			gr.save(g);
								
							    	}
									
							    }
					    }
					   
				  }
			  });
		}
		else
		{
			throw new RitzkidsException("Passenger list is Empty", RitzConstants.ERROR_CODE); 
		}
		
		  
		 bookingId=bid[0];
		return bookingId;
	}
	//get All guardian detail
	@Override
	public List<Guardian> getAllGuardian() throws RitzkidsException 
	{
		List<Guardian> g=new ArrayList<Guardian>();
		gr.findAll().forEach(g::add);
		return g;
	}
	
	//get guardian detail
	@Override
	public Guardian getGuardian(int gid) throws RitzkidsException 
	{
		Optional<Guardian>  guardian=gr.findById(gid);
		
		if(!guardian.isPresent())
		{
			throw new RitzkidsException("No guardian were found in this ID", RitzConstants.ERROR_CODE);
		}
		else
		{
			return guardian.get();
		}
		 
	}

	//get Guardian by Folio ID
	@Override
	public List<Guardian> getAllGuardianByBookingId(long bid) throws RitzkidsException 
	{
		List<Guardian> g=new ArrayList<Guardian>();
		gr.getGuardianBybookingID(bid).forEach(g::add);
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
