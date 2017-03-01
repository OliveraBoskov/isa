package com.projekat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.DrinkOrderItem;
import com.projekat.repository.DrinkOrderItemRepository;

@Service
public class DrinkOrderItemService {

	@Autowired
	private DrinkOrderItemRepository drinkOrderItemRepository;
	
	
	public DrinkOrderItem add(DrinkOrderItem doi) {
		return drinkOrderItemRepository.save(doi);
	}
	
	public Integer setPreparedForDrinkOrderItem(Boolean prepared, Integer id){
		return drinkOrderItemRepository.setIsPreparedForDrinkOrderItem(prepared, id);
	}
	
}
