package com.java.annotations.food;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meal implements Serializable {

	
	private Fruit fruit;
	
	private Dairy dairy;
	
	private Grain grain;
	
	private Meat meat;
	
	private Vegetable veg;
	
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
