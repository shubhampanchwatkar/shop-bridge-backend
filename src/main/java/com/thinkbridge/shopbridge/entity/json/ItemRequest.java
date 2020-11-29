package com.thinkbridge.shopbridge.entity.json;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ItemRequest {
	
	@NotEmpty(message = "Please provide a name")
	private String name;
	
	@NotEmpty(message = "Please provide a description")
	private String description;
		
	@NotNull(message = "Please provide a price")
	@Min(value = 1, message = "Please provide a price")
	private String price;
}
