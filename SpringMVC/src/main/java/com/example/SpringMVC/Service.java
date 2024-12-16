package com.example.SpringMVC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
  
	@Autowired
	Dao dao;
	public List<IPLTeams> getIplTeams() throws ClassNotFoundException, SQLException{
		List<IPLTeams> iplteams = dao.getIplTeams();
		
		return iplteams;
	}
	public String saveIplTeam(IPLTeams iplteam) throws ClassNotFoundException, SQLException {
		String msg =dao.insertIPLTeam(iplteam);
		return msg;
	}
	
	public String updateIplTeam(String captainName, String teamName) throws ClassNotFoundException, SQLException {
		String msg =dao.update(captainName, teamName);
		
		return msg;
	}
	
	public String updateAllData(IPLTeams iplteam) throws ClassNotFoundException, SQLException {
		String msg =dao.updateAllData(iplteam);
		
		return msg;
	}
	
	public String deleteByTeamName(String teamName) throws ClassNotFoundException, SQLException {
		String str =dao.deleteTeam(teamName);
		
		return str;
	}
}
