package com.java.annotations.food;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class Grain {

	public String talkAboutYourself() {
		return "Hi I am Grain, I come from plants";
	}
}
