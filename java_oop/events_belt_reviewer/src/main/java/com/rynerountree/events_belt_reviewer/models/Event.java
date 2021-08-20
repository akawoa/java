package com.rynerountree.events_belt_reviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	//MEMBER VARIABLES
    @Size(min=3, message="Name must be greater than 3 characters")
    @NotEmpty(message = "Must provide an event name")
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull(message = "Must provide a date")
	@Future
	private Date eventDate;
	
    @Size(min=3, message="Location must be greater than 3 characters")
    @NotEmpty(message = "Must provide a location")
	private String location;
	
    @NotEmpty(message = "Must provide a state")
	private String state;
	
	//RELATIONSHIPS
    //MANY TO ONE FUNCTIONALITY FOR HOST
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") //FOREIGN KEY NAME
	private User user;
	
	//MANY TO MANY FUNCTIONALITY FOR JOINING AND EVENT
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "event_attendees", 
        joinColumns = @JoinColumn(name = "event_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usersAttending;
//	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
//	private List<JoinEvent> joinEvents;
	//CONSTRUCTOR
	//EMPTY
	public Event() {
		
	}

	//FULL
	public Event(String name, Date eventDate, String location, String state) {
		super();
		this.name = name;
		this.eventDate = eventDate;
		this.location = location;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

	public List<User> getUsersAttending() {
		return usersAttending;
	}

	public void setUsersAttending(List<User> usersAttending) {
		this.usersAttending = usersAttending;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
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
