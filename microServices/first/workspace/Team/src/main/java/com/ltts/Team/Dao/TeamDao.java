package com.ltts.Team.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ltts.Team.Model.Team;
@Repository
public class TeamDao {
	public List<Team> getAllTeams()
	{
		List <Team> li = new ArrayList<Team>();
		li.add(new Team(1, "IndiaTeam", "India"));	
		li.add(new Team(2, "EnglandTeam", "England"));		
		li.add(new Team(3, "AustraliaTeam", "Australia"));		
		return li;		
		
	}
}
