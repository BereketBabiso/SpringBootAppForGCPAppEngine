package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired RedisTemplate<String, Object> rt;
	
	@GetMapping("/student")
	public Student testRedisServer() {
		Student st = new Student();
		st.setId("112");
		st.setName("Jacky");
		
		rt.opsForHash().put("STUDENT", st.getId(), st);
		
		
		return (Student) rt.opsForHash().get("STUDENT", st.getId());
	}
	
	@GetMapping("/student/{id}")
	@Cacheable(value = "STUDENT")
	public Student getStudentFromCacheTest(@PathVariable String id) {
		System.out.println(">>>>>>>Getting from the cache explicity");
		return (Student) rt.opsForHash().get("STUDENT", id);
	}
	
	

}
