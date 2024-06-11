package com.employee.triarq.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.triarq.Employee.model.Employee;

//JPA Repository (Java Persistence API)
//Extend Inherates 
//<Employee, Long>: These are Java generics. Employee is the entity type the repository manages and 
//Long is the type of the entity’s primary key.

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


	
	
//For getting the all employee by team name
////
//	@Query("SELECT employees.first_name, employees.last_name, team.team_name \r\n"
//			+ "FROM employees  \r\n"
//			+ "INNER JOIN team ON employees.team_id = team.team_id \r\n"
//			+ "WHERE team.team_name =:teamName\r\n"
//			+ "")
//
//		 List<Employee> findEmployeesByTeamName(@Param("teamName") String teamName);
	
}
  


 