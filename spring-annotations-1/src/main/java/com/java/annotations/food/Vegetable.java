package com.java.annotations.food;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class Vegetable {

	public String talkAboutYourself() {
		return "Hi I am Vegetable, I come from plants or trees";
	}
}
