package com.rynerountree.events_belt_reviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    // MEMBER VARIABLES
    
    @Size(min=3, message="First Name must be greater than 3 characters")
    @NotEmpty(message = "Must provide a first name")
    private String firstName;
    
    @Size(min=5, message="Password must be greater than 3 characters")
    @NotEmpty(message = "Must provide a last name")     
    private String lastName;      
    
    @Size(min=5, message="Password must be greater than 5 characters")
    @NotEmpty(message = "Must have password")    
    private String location;    
    
    @NotEmpty(message = "State is required")    
    private String state;    
    
    @Email(message = "Must have valid email format")
    private String email;
    
    @Size(min=5, message="Password must be greater than 5 characters")
    @NotEmpty(message = "Must have password")
    private String password;
    
    @Transient
    private String passwordConfirmation;
    
    // RELATIONSHIPS
    //ONE TO MANY RELATIONSHIP BETWEEN USER HOST AND EVENTS
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Event> events;
    
    //MANY TO MANY FUNCTIONALITY FOR JOINING AN EVENT
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "event_attendees", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> eventsAttending;
//    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<JoinEvent> joinEvents;
    
    
    // CONSTRUCTORS
    public User() {
    	
    }
    public User(String firstName, String lastName, String location, String state, String email, String password, String passwordConfirmation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.state = state;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}

	// GETTERS AND SETTERS
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	



	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public List<Event> getEventsAttending() {
		return eventsAttending;
	}
	public void setEventsAttending(List<Event> eventsAttending) {
		this.eventsAttending = eventsAttending;
	}




	// CREATED AND UPDATED AT
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}