package com.learning.hibernaterefresh.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String details;

	private Timestamp postedOn;

	@ManyToOne
	private User user;

	@PreUpdate
	public void preUpdate() {
		System.out.println("Updated POST");
		postedOn = Timestamp.valueOf(LocalDateTime.now());
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(long id, String details, Timestamp postedOn) {
		super();
		this.id = id;
		this.details = details;
		this.postedOn = postedOn;
	}

	public Post(long id, String details) {
		super();
		this.id = id;
		this.details = details;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Timestamp getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Timestamp postedOn) {
		this.postedOn = postedOn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", details=" + details + ", postedOn=" + postedOn + "]";
	}

}
