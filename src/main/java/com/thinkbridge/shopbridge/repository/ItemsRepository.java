package com.thinkbridge.shopbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkbridge.shopbridge.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Long> {
	
}
