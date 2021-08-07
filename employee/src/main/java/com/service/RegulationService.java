package com.service;

import java.sql.SQLException;
import java.util.List;

import com.classes.Regulation;
import com.dao.RegulationDao;
import com.dao.RegulationDao;

public class RegulationService {

	public String addRegulation(Regulation regulation) throws SQLException
	{
		RegulationDao regulationDao = new RegulationDao();
		if(regulationDao.addRegulation(regulation) > 0) 
		{
			return "success";
		}
		else 
		{
			return "failure";
		}
	}
	
	public String deleteRegulation(Regulation regulation) 
	{
		RegulationDao regulationDao = new RegulationDao();
		if(regulationDao.deleteRegulation(regulation) > 0) 
		{
			return "success";
		}
		else 
		{
			return "failure";
		}
	}
	
	public List<Regulation> getRegulation(String departmentName) {
		
		RegulationDao regulationDao = new RegulationDao();
		return regulationDao.viewAllRegulations(departmentName);
	}
	

}
