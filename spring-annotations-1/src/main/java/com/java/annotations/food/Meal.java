package com.java.annotations.food;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@Component
public class Meal implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Fruit fruit;
	private final Dairy dairy;
	private final Grain grain;
	private final Meat meat;
	private final Vegetable veg;
	
	public String whatsInThisMeal() {
		
		String answer = "This meal contains: ";
		
		if(fruit != null) {
			answer += "some fruit: ";
		}
		if(dairy != null) {
			answer += "some dairy: ";
		}
		if(grain != null) {
			answer += "some grain: ";
		}
		if(meat != null) {
			answer += "some meat: ";
		}
		if(veg != null) {
			answer += "some vegetables: ";
		}
		return answer;
	}
}
