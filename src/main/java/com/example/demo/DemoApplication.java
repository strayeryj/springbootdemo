package com.example.demo;

import com.example.demo.controller.WaterController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	@RequestMapping("/index")
	public String index(){
	 return "Hello Spring boot";
	}

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

		System.out.println("jarTest");
		SpringApplication app = new SpringApplication(DemoApplication.class);
		//app.setShowBanner(false);//已过时，没看见替代的方法
		app.run(args);
	}



}
