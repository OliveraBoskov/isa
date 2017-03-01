package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.DrinkOrderList;
import com.projekat.model.Korisnik;
import com.projekat.model.Zaposleni;
import com.projekat.repository.DrinkOrderListRepository;


@Service
public class DrinkOrderListService {

	@Autowired
	private DrinkOrderListRepository drinkOrderListRepository;

	public DrinkOrderList add(DrinkOrderList dol) {
		return drinkOrderListRepository.save(dol);
	}

	public DrinkOrderList getById(Integer id) {
		return drinkOrderListRepository.findOne(id);
	}
	
	public Collection<DrinkOrderList> getByRestaurantIdAndNonServed(Integer restaurantId, Boolean isServed) {
		return drinkOrderListRepository.findByRestaurantIdAndIsServed(restaurantId, isServed);
	}

	public Integer setServedOrPaid(Boolean isServed, Boolean isPaid, Integer id, Zaposleni waiter, String datePaid) {
		if (isPaid == false) {
			datePaid = null;
			waiter = null;
		}
		return drinkOrderListRepository.setIsServedIPaidForDrinkOrderList(isServed, isPaid, id, waiter, datePaid);
	}

	public Collection<DrinkOrderList> getByRestaurantIdAndNonServedOrNotPaid(Integer restaurantId, Boolean b) {
		return drinkOrderListRepository.findByIsPaid(false);
	}

	public Collection<DrinkOrderList> getAllUserOrdersForRating(String email) {
		return drinkOrderListRepository.findByGuestIdAndIsRatedAndIsPaid(email, false, true);
	}
	
	public Integer setRatedForDrinkOrderList(Integer id){
		return drinkOrderListRepository.setIsRatedForDrinkOrderList(true, id);
	}
	
	
	public Collection<DrinkOrderList> getProfitsInRange(Integer restaurantId, String date1, String date2) {
		return drinkOrderListRepository.findByRestaurantIdAndDatePaidBetween(restaurantId, date1, date2);
	}
	
	public Collection<DrinkOrderList> getVisitsInRange(Boolean isPaid, Integer restaurantId, String date1, String date2) {
		return drinkOrderListRepository.findByIsPaidAndRestaurantIdAndDatePaidBetween(isPaid, restaurantId, date1, date2);
	}

	public Collection<DrinkOrderList> getProfitsForWaiter(Integer restaurantId, Zaposleni waiter) {
		return drinkOrderListRepository.findByRestaurantIdAndWaiter(restaurantId, waiter);
	}
	
}
