package com.ptit;

import com.ptit.Entities.Post;

import com.ptit.Entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import com.ptit.Dao.Dao;

@SpringBootApplication
public class NewsApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}
	@Bean
    public CommandLineRunner commandLineRunner(Dao dao){
        return runner -> {
        	System.out.println("Hello world");
        	//getPosts(dao);

			getU(dao);
        };
    }

	private void getPosts(Dao dao) {
		List<Post> posts = new ArrayList<>();
		posts = dao.getPost();
		System.out.println("posts");
	}

	private void getU(Dao dao){
		List<User> user = new ArrayList<>();
		user = dao.getUser();
		System.out.println("user");
	}

	
}

