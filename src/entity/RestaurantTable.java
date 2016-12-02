package entity;

import static javax.persistence.CascadeType.ALL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
@Table(name = "RESTAURANT_TABLE")
public class RestaurantTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESTAURANT_TABLE_ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "NAME", unique = false, nullable = false)
	private String name;
	
	@Column(name = "EXIST", unique = false, nullable = false)
	private boolean tableExist;
	
	@OneToOne(cascade = { ALL }, fetch = FetchType.EAGER)
	private Restaurant restaurant;
	
	@OneToMany(cascade = { ALL }, fetch = FetchType.EAGER)
	private List<Reservation> reservations;
	
	public RestaurantTable() {

	}

	public RestaurantTable(String name, boolean tableExist, Restaurant restaurant) {
		super();
		this.name = name;
		this.tableExist = tableExist;
		this.restaurant = restaurant;
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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public boolean isTableExist() {
		return tableExist;
	}

	public void setTableExist(boolean tableExist) {
		this.tableExist = tableExist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		RestaurantTable other = (RestaurantTable) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public boolean isTableFree(String startDateString, String endDateString) {
		String dateTimeFormat = "yyyy-MM-dd hh:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormat);
		
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = sdf.parse(startDateString);
			endDate = sdf.parse(endDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		if(reservations == null){
			return true;	
		}
		
		for(Reservation reservation : reservations) {
			if((startDate.after(reservation.getStartDate()) && startDate.before(reservation.getEndDate()))
					|| endDate.after(reservation.getStartDate()) && endDate.before(reservation.getEndDate())){
				return false;
			}
		}
		
		return true;
	}

}
