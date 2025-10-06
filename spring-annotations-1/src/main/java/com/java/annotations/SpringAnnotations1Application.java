package com.java.annotations;

import com.java.annotations.food.Meal;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringAnnotations1Application implements CommandLineRunner {
	
	private final Meal meal;

	public static void main(String[] args) {
		SpringApplication.run(SpringAnnotations1Application.class, args);
	
//		ApplicationContext appContext = new ClassPathXmlApplicationContext("myTestPackage");
//	
//		Meal myAnnotatedSpringMeal = appContext.getBean("mealByAnnotation", Meal.class);
//		System.out.println("Spring Meal : " + myAnnotatedSpringMeal.whatsInThisMeal());
//		((ClassPathXmlApplicationContext) appContext).close();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring Meal : " + meal.whatsInThisMeal());
		
	}
}
