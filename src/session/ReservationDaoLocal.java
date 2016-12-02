package session;

import java.util.List;

import entity.Reservation;
import entity.User;

public interface ReservationDaoLocal extends GenericDaoLocal<Reservation, Integer> {
	
	public List<Reservation> findReservationWithUserId(Integer userId);
	
}
