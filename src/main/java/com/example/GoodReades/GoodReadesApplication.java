package com.example.GoodReades;
import com.example.GoodReades.controller.BookController;

import com.example.GoodReades.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.GoodReades.repository.*;
import com.example.GoodReades.service.BookMYSQLService;



@SpringBootApplication
public class GoodReadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodReadesApplication.class, args);
	}

}
