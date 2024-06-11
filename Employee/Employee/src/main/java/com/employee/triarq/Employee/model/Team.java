package com.employee.triarq.Employee.model;
import java.util.List;

import jakarta.persistence.*;


//First Entity Team
//why entity what is entity 


//spring boot annotations @Id,@Entity (like ER) diagram for DB 
//

//Entity- Relation to each other
@Entity
@Table(name = "team")
public class Team {
	//Auto Generated ID & using this as a primary key for our table (@GeneratedValue(strategy = GenerationType.IDENTITY)) 
	//what column should be define them first then write their getters & setters to get the data in the objects like .this etc. 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	
	@Column (name ="team_id")
    private Long teamid;
	
	
	
	@Column(name = "team_name")
    private String teamName;
	
	
	@OneToMany(mappedBy = "team")
	private List<Employee> employees;

	


	public Long getTeamid() {
		return teamid;
	}


	public void setTeamid(Long teamid) {
		this.teamid = teamid;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}

