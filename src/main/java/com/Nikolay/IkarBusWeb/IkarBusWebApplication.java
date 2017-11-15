package com.Nikolay.IkarBusWeb;

import com.Nikolay.IkarBusWeb.controller.IndexController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class IkarBusWebApplication{

	public static void main(String[] args) throws  Exception{
		SpringApplication.run(IkarBusWebApplication.class, args);
	}
}
