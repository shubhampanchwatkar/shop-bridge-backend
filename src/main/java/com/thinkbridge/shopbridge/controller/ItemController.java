package com.thinkbridge.shopbridge.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thinkbridge.shopbridge.entity.Items;
import com.thinkbridge.shopbridge.entity.json.ItemRequest;
import com.thinkbridge.shopbridge.repository.ItemsRepository;

@RestController
@RequestMapping("/public")
@CrossOrigin
public class ItemController {
	
	@Autowired 
	private ItemsRepository itemsRepository;
	
	// add new item
	@PostMapping("/items")
	public Items addItem(@Valid @RequestBody ItemRequest itemRequest) {
		Items items = 
				Items.builder()
					.name(itemRequest.getName())
					.description(itemRequest.getDescription())
					.price(Long.parseLong(itemRequest.getPrice()))
					.build();
		itemsRepository.save(items);
		return items;
	}
	
	// return list of items
	@GetMapping("/items")
	public List<Items> findAllItems() {
		return itemsRepository.findAll();
	}
	
	// delete item
	@DeleteMapping("/items/{itemId}")
	public String deleteItem(@PathVariable long itemId) {		
		Items item = itemsRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item id not found - "+ itemId));
		itemsRepository.delete(item);		
		return "Deleted item with id - " + itemId;
	}
	
}
