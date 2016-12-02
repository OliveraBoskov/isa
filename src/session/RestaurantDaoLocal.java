package session;

import entity.Restaurant;

public interface RestaurantDaoLocal extends GenericDaoLocal<Restaurant, Integer> {
	
	public Restaurant findRestaurantWithName(String name);

}