package entity;

import static javax.persistence.CascadeType.ALL;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RESTAURANT")
@NamedQueries({
	@NamedQuery(name = "findRestaurantWithName", query = "SELECT restaurant FROM Restaurant restaurant WHERE restaurant.name = :name")
	
})
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESTAURANT_ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "NAME", unique = false, nullable = false)
	private String name;
	
	@Column(name = "DESCRIPTION", unique = false, nullable = false)
	private String description;
	
	@OneToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	private List<MenuItem> menuItems;
	
	@OneToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	private List<Reservation> reservations;
	
	@OneToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	private List<RestaurantTable> restaurantTable;
	
	@OneToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	private List<Rating> ratings;
	
	@OneToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	private List<User> managers;

	
	public double getAverage() {
		if(ratings == null){
			return 0;
		}
		double average = 0;
		for(Rating r : ratings){
			average += r.getRating();
		}
		if(ratings.size() != 0){
			average /=  ratings.size();
		}

		return average;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<RestaurantTable> getRestaurantTable() {
		return restaurantTable;
	}

	public void setRestaurantTable(List<RestaurantTable> restaurantTable) {
		this.restaurantTable = restaurantTable;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	
	public List<User> getManagers() {
		return managers;
	}

	public void setManagers(List<User> managers) {
		this.managers = managers;
	}

	public Restaurant(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Restaurant() {
	}
	
	public boolean isUserManager(User user)
	{
		if(managers.contains(user)){
			return true;
		}
		else {
			return false;
		}
	}
}
