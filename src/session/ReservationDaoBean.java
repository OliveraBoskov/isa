package session;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import entity.Reservation;
import entity.User;

@Stateless
@Local(ReservationDaoLocal.class)
public class ReservationDaoBean extends GenericDaoBean<Reservation, Integer> implements ReservationDaoLocal {

	protected Logger log = Logger.getLogger(ReservationDaoBean.class);
	
	@Override
	public List<Reservation> findReservationWithUserId(Integer userId) {
		
		//List<Reservation> result = new List<Reservation>();
		//try {
			Query q = em
					.createNamedQuery("SELECT r FROM Reservation r WHERE r.user.id = :userId");
			q.setParameter("userId", userId);
			
			
			@SuppressWarnings("unchecked")
			List<Reservation> result = (List<Reservation>) q.getResultList();
		/*}
		catch(NoResultException e) {
			log.info("No result for reservations fow user with id: " + userId);
		}*/
		
		return result;
	}
}
