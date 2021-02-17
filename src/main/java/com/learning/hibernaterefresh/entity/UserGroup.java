package com.learning.hibernaterefresh.entity;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Entity;
import javax.persistence.Id;
 

@Entity
public class UserGroup {

	@Id
	private long id;
	private String name;
//	private List<User> users;

	public UserGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserGroup(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
