package entity;

import static javax.persistence.CascadeType.ALL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESERVATION_ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "START_DATE", unique = false, nullable = false)
	private Date startDate;
	
	@Column(name = "END_DATE", unique = false, nullable = false)
	private Date endDate;
	
	@OneToOne(cascade = { ALL }, fetch = FetchType.EAGER)
	private Restaurant restaurant;
	
	@OneToOne(cascade = { ALL }, fetch = FetchType.EAGER)
	private User user;
	
	@OneToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	private List<FriendInvitation> invitedFriends;
	
	@OneToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	private List<Rating> ratings;
	
	@OneToOne(cascade = { ALL }, fetch = FetchType.EAGER)
	private RestaurantTable table;
	
	public boolean canUserMakeRating(User user){
		
		if(ratings == null){
			return true;
		}
		
		for(Rating r:ratings){
			if(r.getUser().equals(user)){
				return false;
			}
		}
		
		return true;	
	}
	
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<FriendInvitation> getInvitedFriends() {
		return invitedFriends;
	}

	public void setInvitedFriends(List<FriendInvitation> invitedFriends) {
		this.invitedFriends = invitedFriends;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public RestaurantTable getTable() {
		return table;
	}

	public void setTable(RestaurantTable table) {
		this.table = table;
	}
	
	public Reservation() {
	}

	public Reservation(Date startDate, Date endDate, Restaurant restaurant,
			User user, RestaurantTable table) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.restaurant = restaurant;
		this.user = user;
		this.table = table;
	}
	
	public String getStartDateString(){
		String dateTimeFormat = "yyyy-MM-dd hh:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormat);
		
		return sdf.format(startDate);
	}
	
	public String getEndDateString(){
		String dateTimeFormat = "yyyy-MM-dd hh:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormat);
		
		return sdf.format(endDate);
	}
	
	public boolean isReservationFinished(){
		Date d = new Date();
		
		if(d.after(endDate)){
			return true;
		}
		
		return false;
	}
	
}
