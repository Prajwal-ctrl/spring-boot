package com.employee.triarq.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.employee.triarq.Employee.model.Role;
import com.employee.triarq.Employee.repository.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/role")

public class RoleController {


//automatically inject an instance of RoleRepository into this controller.
	@Autowired
    private RoleRepository roleRepository;
   
    
  
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping("/all")
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public Role getRole(@PathVariable Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    
	@PostMapping("/save")
    public Role saveRole(@RequestBody Role role) {
       return roleRepository.save(role);
    }
	
	 
	@PatchMapping("/save/1")
	    public Role UpdateRole(@RequestBody Role role) {
	       return roleRepository.save(role);
	    }
	
	

}

