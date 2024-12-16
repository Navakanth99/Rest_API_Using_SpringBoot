package com.example.SpringMVC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/* @RestController */
@org.springframework.stereotype.Controller
public class Controller {
    
	@Autowired
	Service service;
	
//	@GetMapping("/iplteam")   //restcontroller
//	public List<IPLTeams> iplteams() throws ClassNotFoundException, SQLException{
//		List<IPLTeams> iplteam = service.getIplTeams();
//
//		return iplteam;
//		}
	
	@GetMapping("/iplteams")   //controller
	public String iplteams(org.springframework.ui.Model model) throws ClassNotFoundException, SQLException{
		model.addAttribute("iplteams", service.getIplTeams());
		return "iplteams";
		}
	
	@PostMapping("/iplteam")
	public String insertIplTeam(@RequestBody IPLTeams iplteam) throws ClassNotFoundException, SQLException {
	  String msg = service.saveIplTeam(iplteam);
	  
	  return msg;
	}
	
	@PutMapping("/iplteam/{captainName}/{teamName}")
	public String updateData(@PathVariable String captainName,@PathVariable  String teamName) throws ClassNotFoundException, SQLException {
		String msg = service.updateIplTeam(captainName, teamName);
		
		return msg;
		
		
	}
	
	@PutMapping("/iplteam")
	public String updateAllDatae(@RequestBody IPLTeams iplteam) throws ClassNotFoundException, SQLException {
		String msg = service.updateAllData(iplteam);
		
		return msg;
		
		
	}
	
	@DeleteMapping("/iplteam/{teamName}")
	public String deleteByTeamName(@PathVariable String teamName) throws ClassNotFoundException, SQLException {
		String msg =service.deleteByTeamName(teamName);
		return msg;
	}
}
