package session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Reservation;
import entity.Restaurant;
import entity.RestaurantTable;
import entity.User;
import entity.UserType;

@Stateless
@Remote(Init.class)
public class InitBean implements Init{

	@PersistenceContext(unitName = "Rezervacije")
	EntityManager em;
	
	@SuppressWarnings("deprecation")
	@Override
	public void init() {
		User user1 = new User("admin", "admin", "adresa","admin@gmail.com", "Veternik91", true, UserType.SYSTEM_MANAGER);
		User user2 = new User("Nebojsa", "Bobic", "adresa","nesa823@gmail.com", "Veternik91", true, UserType.GUEST);
		User user3 = new User("Pera", "Peric", "adresa","1", "1", true, UserType.RESTAURANT_MANAGER);
		User user4 = new User("Jova", "Jovic", "adresa","2", "2", true, UserType.RESTAURANT_MANAGER);
		User user5 = new User("Ana", "Anic", "adresa","3", "3", true, UserType.RESTAURANT_MANAGER);
		User user6 = new User("Eva", "Evic", "adresa","4", "4", true, UserType.RESTAURANT_MANAGER);
		User user7 = new User("Zoka", "Zokic", "adresa","5", "5", true, UserType.GUEST);

		em.persist(user1);
		em.persist(user2);
		em.persist(user3);
		em.persist(user4);
		em.persist(user5);
		em.persist(user6);
		em.persist(user7);
		
		Restaurant restaurant1= new Restaurant("Restoran1", "domaca kuhinja");
		Restaurant restaurant2= new Restaurant("Restoran2", "veganski");
		em.persist(restaurant1);
		em.persist(restaurant2);
		
		List<User> list1 = new ArrayList<User>();
		list1.add(user4);
		restaurant1.setManagers(list1);
		List<Restaurant> managerIn4 = new ArrayList<Restaurant>();
		managerIn4.add(restaurant1);
		user4.setManagerIn(managerIn4);
		
		/*List<Restaurant> managerIn3 = new ArrayList<Restaurant>();
		managerIn3.add(restaurant1);
		user3.setManagerIn(managerIn3);
		
		
		List<User> list2 = new ArrayList<User>();
		list2.add(user5);
		list2.add(user6);
		restaurant2.setManagers(list2);
		
		List<Restaurant> managerIn5 = new ArrayList<Restaurant>();
		managerIn5.add(restaurant2);
		user5.setManagerIn(managerIn5);
		List<Restaurant> managerIn6 = new ArrayList<Restaurant>();
		managerIn6.add(restaurant2);
		user6.setManagerIn(managerIn6);
		em.merge(user5);
		em.merge(user6);
		em.merge(restaurant2);*/
		
		RestaurantTable tb1=new RestaurantTable("1", true, restaurant1);
		RestaurantTable tb2=new RestaurantTable("2", false, restaurant1);
		RestaurantTable tb3=new RestaurantTable("3", true, restaurant1);
		RestaurantTable tb4=new RestaurantTable("4", true, restaurant1);
		RestaurantTable tb5=new RestaurantTable("5", true, restaurant1);
		RestaurantTable tb6=new RestaurantTable("6", true, restaurant1);
		RestaurantTable tb7=new RestaurantTable("7", false, restaurant1);
		RestaurantTable tb8=new RestaurantTable("8", true, restaurant1);
		RestaurantTable tb9=new RestaurantTable("9", true, restaurant1);
		
		em.persist(tb1);
		em.persist(tb2);
		em.persist(tb3);
		em.persist(tb4);
		em.persist(tb5);
		em.persist(tb6);
		em.persist(tb7);
		em.persist(tb8);
		em.persist(tb9);
		
		List<RestaurantTable> tables1= new ArrayList<RestaurantTable>();
		tables1.add(tb1);
		tables1.add(tb2);
		tables1.add(tb3);
		tables1.add(tb4);
		tables1.add(tb5);
		tables1.add(tb6);
		tables1.add(tb7);
		tables1.add(tb8);
		tables1.add(tb9);
		
		restaurant1.setRestaurantTable(tables1);
		
		RestaurantTable tab1=new RestaurantTable("1", true, restaurant2);
		RestaurantTable tab2=new RestaurantTable("2", true, restaurant2);
		RestaurantTable tab3=new RestaurantTable("3", true, restaurant2);
		RestaurantTable tab4=new RestaurantTable("4", false, restaurant2);
		RestaurantTable tab5=new RestaurantTable("5", true, restaurant2);
		RestaurantTable tab6=new RestaurantTable("6", true, restaurant2);
		RestaurantTable tab7=new RestaurantTable("7", true, restaurant2);
		RestaurantTable tab8=new RestaurantTable("8", true, restaurant2);
		RestaurantTable tab9=new RestaurantTable("9", false, restaurant2);
		RestaurantTable tab10=new RestaurantTable("10", true, restaurant2);
		RestaurantTable tab11=new RestaurantTable("11", true, restaurant2);
		RestaurantTable tab12=new RestaurantTable("12", true, restaurant2);
		
		em.persist(tab1);
		em.persist(tab2);
		em.persist(tab3);
		em.persist(tab4);
		em.persist(tab5);
		em.persist(tab6);
		em.persist(tab7);
		em.persist(tab8);
		em.persist(tab9);
		em.persist(tab10);
		em.persist(tab11);
		em.persist(tab12);
		
		List<RestaurantTable> tables2= new ArrayList<RestaurantTable>();
		tables2.add(tab1);
		tables2.add(tab2);
		tables2.add(tab3);
		tables2.add(tab4);
		tables2.add(tab5);
		tables2.add(tab6);
		tables2.add(tab7);
		tables2.add(tab8);
		tables2.add(tab9);
		tables2.add(tab10);
		tables2.add(tab11);
		tables2.add(tab12);
		
		restaurant2.setRestaurantTable(tables2);
		
		Reservation rez1 = new Reservation(new Date(2016,2,23,12,50), new Date(2016,2,23,14,50), restaurant1, user2, tb5);
		Reservation rez2 = new Reservation(new Date(2016,3,23,11,00), new Date(2016,3,23,12,00), restaurant2, user2, tab7);
		Reservation rez3 = new Reservation(new Date(2016,4,25,11,30), new Date(2016,4,25,13,30), restaurant2, user7, tab10);
	
		em.persist(rez1);
		em.persist(rez2);
		em.persist(rez3);
		
		List<Reservation> reservation1 = new ArrayList<Reservation>();
		List<Reservation> userReservation1 = new ArrayList<Reservation>();
		
		reservation1.add(rez1);
		restaurant1.setReservations(reservation1);
		
		userReservation1.add(rez1);
		userReservation1.add(rez2);
		user2.setReservations(userReservation1);
		
		List<Reservation> reservation2 = new ArrayList<Reservation>();
		List<Reservation> userReservation2 = new ArrayList<Reservation>();
		
		reservation2.add(rez2);
		reservation2.add(rez3);
		restaurant2.setReservations(reservation2);
		
		userReservation2.add(rez3);
		user7.setReservations(userReservation2);
		
		em.merge(rez1);
		
		em.merge(rez2);
		em.merge(rez3);
		
		em.merge(user2);
		
		
		em.merge(user7);		
		em.merge(user4);
		em.merge(restaurant1);
		em.merge(restaurant2);
	}
}
