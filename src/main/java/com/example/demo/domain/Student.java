package com.example.demo.domain;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

//@RedisHash("Student")
public class Student implements Serializable {
	
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
