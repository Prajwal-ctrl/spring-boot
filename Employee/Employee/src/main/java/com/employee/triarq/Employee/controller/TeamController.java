package com.employee.triarq.Employee.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee.triarq.Employee.exception.ResourceNotFoundException;
import com.employee.triarq.Employee.model.Employee;
import com.employee.triarq.Employee.model.Team;
import com.employee.triarq.Employee.repository.EmployeeRepository;
import com.employee.triarq.Employee.repository.TeamRepository;




//Performing Inner Join for this so that when there is a match between one of the table we get the data. 

@RestController 
@RequestMapping("/api/team")



public class TeamController{
	
	@Autowired 
	private TeamRepository teamRepository ; 


	
	@GetMapping ("/all")
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

	
	@GetMapping("/{id}")
	public Team getTeam(@PathVariable Long id) {
	    return teamRepository.findById(id).orElseThrow();
	}

	@PostMapping("/save")
	public void saveTeam(@RequestBody Team team) {
	    teamRepository.save(team);
	}
	
	
	
	
	
	
	
}

