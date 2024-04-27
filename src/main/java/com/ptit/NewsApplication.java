package com.ptit;

import com.ptit.Service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class NewsApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}
	@Bean
    public CommandLineRunner commandLineRunner(){
        return runner -> {
        	System.out.println("Hello world");

        };
    }

	@Bean
	public CommandLineRunner init(StorageService storageService){
		return runner -> {
			storageService.init();
			System.out.println("Khoi tao thanh cong");
		};
	}








}

