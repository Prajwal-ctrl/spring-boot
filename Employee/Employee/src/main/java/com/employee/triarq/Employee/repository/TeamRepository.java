package com.employee.triarq.Employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.employee.triarq.Employee.model.Team;

//JPA (API) provides various method for the implementation like to perform CRUD Operations
//save(), findAll(), findById(), delete(), etc
  




@EnableJpaRepositories
public interface TeamRepository extends JpaRepository<Team, Long> {

	
	
	
//	@Query("SELECT employees.first_name, employees.last_name, team.team_name \r\n"
//			+ "FROM employees  \r\n"
//			+ "INNER JOIN team ON employees.id = team.team_id \r\n"
//			+ "WHERE team.team_name = :teamName \r\n"
//			+ "\r\n")
	
	List<Object[]> findEmployeesByTeamName(@Param("teamName") String teamName);

	
	
	
}
