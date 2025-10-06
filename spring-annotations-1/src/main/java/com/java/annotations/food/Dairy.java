package com.java.annotations.food;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class Dairy {

	public String talkAboutYourself() {
		return "Hi I am Dairy, I come from animals";
	}
}
