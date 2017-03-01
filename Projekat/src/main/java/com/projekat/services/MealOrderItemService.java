package com.projekat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.MealOrderItem;
import com.projekat.repository.MealOrderItemRepository;


@Service
public class MealOrderItemService {

	@Autowired
	private MealOrderItemRepository mealOrderItemRepository;
	
	
	public MealOrderItem add(MealOrderItem doi) {
		return mealOrderItemRepository.save(doi);
	}
	
	public Integer setPreparedForMealOrderItem(Boolean prepared, Integer id){
		return mealOrderItemRepository.setIsPreparedForMealOrderItem(prepared, id);
	}

	public Integer setPreparingForMealOrderItem(Boolean preparing, Integer id) {
		return mealOrderItemRepository.setIsPreparingForMealOrderItem(preparing, id);
	}
	
}
