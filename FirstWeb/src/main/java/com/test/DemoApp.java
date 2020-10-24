package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class DemoApp {
	
	@RequestMapping("/")
	  public String home() {
	    return "This is a test from Arun.. grow..";
	  }

	  public static void main(String[] args) {
	    SpringApplication.run(DemoApp.class, args);
	  }


}
