package com.java.annotations.food;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class Fruit {

	public String talkAboutYourself() {
		return "Hi I am fruit, I come from plants or trees with seeds";
	}
}
