package entity;

import static javax.persistence.CascadeType.ALL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_ITEM")
public class MenuItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MENU_ITEM_ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "NAME", unique = false, nullable = false)
	private String name;
	
	@Column(name = "DESCRIPTION", unique = false, nullable = false)
	private String description;
	
	@Column(name = "PRICE", unique = false, nullable = false)
	private Double price;
	
	@Enumerated
	@Column(name = "MENU_ITEM_TYPE", unique = false, nullable = false)
	private MenuItemType userType;
	
	@ManyToOne(cascade = { ALL }, fetch = FetchType.EAGER)
	private Restaurant restaurant;

	public MenuItem() {
	}
	
	public MenuItem(String name, String description, Double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
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
		MenuItem other = (MenuItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
