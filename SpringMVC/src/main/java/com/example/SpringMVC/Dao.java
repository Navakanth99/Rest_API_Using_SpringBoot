package com.example.SpringMVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class Dao {
   
	public ArrayList<IPLTeams> getIplTeams() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl","root","Server18");
		Statement st =con.createStatement();
		ArrayList<IPLTeams> al = new ArrayList<>();
		ResultSet rs =st.executeQuery("select * from iplteams");
		while(rs.next()) {
			String teamName = rs.getString("teamName");
			
			String teamCaptain = rs.getString("teamCaptain");
			String teamOwner = rs.getString("teamOwner");
			int tropies =rs.getInt("tropies");
			IPLTeams iplteam = new IPLTeams(teamName,teamCaptain,teamOwner,tropies);
			al.add(iplteam);
		}
		return al;
	}
	
	public String insertIPLTeam(IPLTeams iplteam) throws ClassNotFoundException, SQLException {
		Connection con =DBConnection.DBconnect();
		 
		PreparedStatement pst = con.prepareStatement("insert into iplteams values(?,?,?,?)");
		 pst.setString(1, iplteam.getTeamname());
		 pst.setString(2, iplteam.getCaptainName());;
		 pst.setString(3, iplteam.getOwner());
		 pst.setInt(4, iplteam.getTrophy());
		 
		 pst.executeUpdate();
		 return "data has been inserted";
		}
	
	public String update(String captainName, String teamName) throws ClassNotFoundException, SQLException {
		Connection con =DBConnection.DBconnect();
		PreparedStatement pst = con.prepareStatement("update iplteams set teamCaptain=? where teamName=?");
		pst.setNString(1, captainName);
		pst.setString(2, teamName);
		pst.executeUpdate();
		
		return "Updated Succesfully";
	}
	
	public String updateAllData(IPLTeams iplteam) throws ClassNotFoundException, SQLException {
		Connection con =DBConnection.DBconnect();
		PreparedStatement pst = con.prepareStatement("update iplteams set teamCaptain=?, teamOwner=?, tropies=? where teamName=?");
		pst.setNString(1, iplteam.getCaptainName());
		pst.setString(2, iplteam.getOwner());
		pst.setInt(3, iplteam.getTrophy());
		pst.setString(4, iplteam.getTeamname());
		pst.executeUpdate();
		
		return "Updated Succesfully";
	}
	
	public String deleteTeam(String teamName) throws ClassNotFoundException, SQLException {
		Connection con =DBConnection.DBconnect();
		PreparedStatement pst = con.prepareStatement("delete from iplteams where teamName=?");
		pst.setString(1, teamName);
		pst.executeUpdate();
		
		return "delete Successfully";
		
	}
}
