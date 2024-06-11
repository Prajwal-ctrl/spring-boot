//Refer the above documet: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/
//For Http request essential for REST-API in spring.  
//documentation: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/



package com.employee.triarq.Employee.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.triarq.Employee.exception.ResourceNotFoundException;
import com.employee.triarq.Employee.model.Employee;
import com.employee.triarq.Employee.repository.EmployeeRepository;


@RestController
@RequestMapping("/api/v1/")



public class EmployeeController {

	
//Making private object of type Employee for class Employee
//@Autowired annotation to automatically inject an instance of EmployeeRepository into this controller.	injected employeeRepository bean into this one
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}		
	
	// create employee rest api
//Takes employee object as a parameter & return Employee object 
//@RequestBody => information about the Employee should be gathered from the body of incoming http request.
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	// get employee by id rest api
//Takes id as a parameter returns object employee to the ResponseEntity. returning its response i.e. 200 and all that 
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	// update employee rest-api
	// Reference: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html
	//curly braces {} are used to define path variables within the URI template. {id} indicates the dynamic value for each id 
	
	// when employees/id will hit it will invoke updteEmployee function,  
		
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest-api
	//Map will give response in a format of "deleted,True" 200 or "Employee not found" or 
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
//	@GetMapping("/employeesByTeam")
//    public List<Object[]> getEmployeesByTeamName(@RequestParam("teamName") String teamName) {
//        return employeeRepository.findEmployeesByTeamName(teamName);
//    }
	
	
//	 @GetMapping("/employees/team/{teamName}")
//	    public List<Employee> getEmployeesByTeamName(@PathVariable String teamName) {
//	        return employeeRepository.findEmployeesByTeamName(teamName);
//	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}