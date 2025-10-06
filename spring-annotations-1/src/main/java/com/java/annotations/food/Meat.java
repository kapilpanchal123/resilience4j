package com.java.annotations.food;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class Meat {

	public String talkAboutYourself() {
		return "Hi I am Meat, I come from animals";
	}
}
