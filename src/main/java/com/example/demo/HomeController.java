package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {
	
	@Value("${appname}")
	String appName;
	
	@GetMapping
	public String test() {
		String hostAddress = "DefaultHostAddress";
		String hostName = "DefaultHostName";
		try {
		hostAddress = InetAddress.getLocalHost().getHostAddress();
		hostName = InetAddress.getLocalHost().getHostName();
		} catch(UnknownHostException ex) {
			ex.printStackTrace();
		}
		return "returning this greeting from gcp app engine app called :: " + appName + " : Hi there! :: " + hostAddress + "::" + hostName;
	}

}
