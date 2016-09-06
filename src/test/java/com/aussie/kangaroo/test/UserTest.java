package com.aussie.kangaroo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aussie.kangaroo.DAO.UserDAO;
import com.aussie.kangaroo.model.User;


public class UserTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		 context.scan("com.aussie.kangaroo");
		 context.refresh();
		 UserDAO UserDetailsDAO =(UserDAO) context.getBean("UserDAO");
		 User UserDetails =(User) context.getBean("user");

		 UserDetails.setName("ganesh");
		 
		 UserDetails.setEmail("vemuriganeshg@gmail.com");
		 UserDetails.setPassword("ganeshv");
		 UserDetails.setMobile("8185956671");
		 UserDetails.setAddress("Hyderabad");
		if(UserDetailsDAO.save(UserDetails)==true){
			System.out.println("a");
		}
		else{
			System.out.println("b");
		}
			}

		}
