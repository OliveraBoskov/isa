package entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@NamedQueries({
	@NamedQuery(name = "findUserWithEmail", query = "SELECT user FROM User user WHERE user.email = :email"),
	@NamedQuery(name = "findUserWithEmailAndPassword", query = "SELECT user FROM User user WHERE user.email = :email AND user.password = :password")
})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "FIRST_NAME", unique = false, nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", unique = false, nullable = false)
	private String lastName;
	
	@Column(name = "ADDRESS", unique = false, nullable = false)
	private String address;
	
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	
	@Column(name = "PASSWORD", unique = false, nullable = false)
	private String password;
	
	@Column(name = "ACTIVE", unique = false, nullable = false)
	private boolean isActive;
	
	@Enumerated
	@Column(name = "USER_TYPE", unique = false, nullable = false)
	private UserType userType;
	
	@ManyToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "FRIENDS", joinColumns = @JoinColumn(name = "USER_ID"),
	inverseJoinColumns = @JoinColumn(name = "FRIEND_ID"))
	private List<User> friends;
	
	@ManyToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	@JoinTable(name="FRIENDS",
	joinColumns=@JoinColumn(name="FRIEND_ID"),
	inverseJoinColumns=@JoinColumn(name="USER_ID"))
	private List<User> friendOf;
	
	@OneToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	private List<Reservation> reservations;
	
	@OneToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	private List<Rating> ratings;
	
	@OneToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	private List<Restaurant> managerIn;
	
	@OneToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	private List<FriendInvitation> friendInvitations;
	
	public int getVisits(){
		int visits = reservations.size();
		
		for(FriendInvitation i : friendInvitations){
			if(i.isAccepted())
			{
				visits++;
			}
		}
		
		return visits;
	}
	
	public User()
	{
		
	}
	
	public User(String firstName, String lastName, String address, String email,
			String password, boolean isActive, UserType userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.userType = userType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<User> getFriends() {
		if(friends == null){
			friends = new ArrayList();
		}
		
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<User> getFriendOf() {
		return friendOf;
	}

	public void setFriendOf(List<User> friendOf) {
		this.friendOf = friendOf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	public List<FriendInvitation> getFriendInvitations() {
		return friendInvitations;
	}

	public void setFriendInvitations(List<FriendInvitation> friendInvitations) {
		this.friendInvitations = friendInvitations;
	}

	public List<Restaurant> getManagerIn() {
		return managerIn;
	}

	public void setManagerIn(List<Restaurant> managerIn) {
		this.managerIn = managerIn;
	}

	public boolean isUserSystemManager() {
		return userType == UserType.SYSTEM_MANAGER;
	}
	
	public boolean isUserRestaurantManager() {
		return userType == UserType.RESTAURANT_MANAGER;
	}
	
	public boolean isUserGuest() {
		return userType == UserType.GUEST;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
