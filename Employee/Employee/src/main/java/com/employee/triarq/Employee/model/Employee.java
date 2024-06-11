package com.employee.triarq.Employee.model;

import jakarta.persistence.*;


//We cannot have multiple inheritance in java i.e 2 same method in a same class i.e. why we use interfaces
//below we see this are annotations like @Id, @coloumn which specifies (internally they are Interfaces)
@Entity
@Table (name = "employees")

public class Employee {
	

	
	//This one here to generate the primary key for the table employees 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id ; 

	
	@Column(name = "first_name")
	private String firstName; 

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;
	
//Defining the relationships with other entities like employee, role,team how they are associated with each other i.e 
//linking them with each other
	
//JoinColumn annotations specifies the foreign key column in db i.e. map to the associated entity. 	
	 
// Employee can have one Role	
	
	@ManyToOne
	    @JoinColumn(name = "role_id")
	    private Role role;
	 
//Can have one team 
	
	
	 @ManyToOne
	    @JoinColumn(name = "team_id") 
	    private Team team;
	 
	 
	 @ManyToOne
	    @JoinColumn(name = "fk_emp_id")
	    private Employee employee;
	
//constructor for class Employee & when nothing is getting called this shit will be called 					
	public Employee () {
		

	}
	
//second constructor will call when we give three parameters & accessing this using .this keyword & getters & setters in the code. 
//whenever new record will created (object will map it down) using this keyword 
	
	
	public Employee(String firstName, String lastName, String emailId) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	
	
	//Getters & setters for the object
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	
}


	
	


