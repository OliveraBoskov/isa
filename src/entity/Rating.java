package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RATING")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RATING_ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RATING", unique = false, nullable = false)
	private Integer rating;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Reservation reservation;
	
	@OneToOne
	private Restaurant restaurant;
	
	public Rating(){
	}
	
	public Rating(Integer rating, User user, Reservation reservation, Restaurant restaurant) {
		super();
		this.rating = rating;
		this.user = user;
		this.reservation = reservation;
		this.restaurant = restaurant;
	}

	public Integer getId() {
		return id;
	}
	
	public Integer getRating() {
		return rating;
	}
	
	public Integer getRestaurantId() {
		if(restaurant != null)
		{
			return restaurant.getId();
		}
		else
			return 5;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
}
