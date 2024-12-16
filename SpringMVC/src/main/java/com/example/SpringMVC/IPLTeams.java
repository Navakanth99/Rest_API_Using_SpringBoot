package com.example.SpringMVC;

public class IPLTeams {
   
	String teamname;
	String captainName;
	String owner;
	public IPLTeams(String teamname, String captainName, String owner, int trophy) {
		super();
		this.teamname = teamname;
		this.captainName = captainName;
		this.owner = owner;
		this.trophy = trophy;
	}
	int trophy;
	
	@Override
	public String toString() {
		return "IPLTeams [teamname=" + teamname + ", captainName=" + captainName + ", owner=" + owner + ", trophy="
				+ trophy + "]";
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public String getCaptainName() {
		return captainName;
	}
	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getTrophy() {
		return trophy;
	}
	public void setTrophy(int trophy) {
		this.trophy = trophy;
	}
}
