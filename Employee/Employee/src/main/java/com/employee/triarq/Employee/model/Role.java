package com.employee.triarq.Employee.model;
import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;

import jakarta.persistence.*;



@Entity
@Table (name = "organizatinal_role")

//Always give String name in camelCase it doesn't take capital letters at the beginning


public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "role_id")
	private Long roleId;

	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "role")
	private String role ;
   
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    
    
 // Normal Constructor    
    public Role () {
    	
    }
    
 //Constructor with arguments: 
    public Role (String fullName, String role, Long roleId) {
    	this.fullName = fullName ; 
    	this.role = role ; 
    	this.roleId = roleId ; 
    }


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Long getRoleid() {
		return roleId;
	}


	public void setRoleid(Long roleId) {
		this.roleId = roleId;
	}
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
}
