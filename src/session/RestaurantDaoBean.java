package session;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import entity.Restaurant;

@Stateless
@Local(RestaurantDaoLocal.class)
public class RestaurantDaoBean extends GenericDaoBean<Restaurant, Integer> implements RestaurantDaoLocal {
	protected Logger log = Logger.getLogger(RestaurantDaoBean.class);
	
	@Override
	public Restaurant findRestaurantWithName(String name) {
		Query q = em
				.createNamedQuery("findRestaurantWithName");
		q.setParameter("name", name);
		Restaurant result = null;
		
		try {
			result = (Restaurant) q.getSingleResult();
		}
		catch(NoResultException e) {
			log.info("No result for name: " + name);
		}
		
		return result;
	}

}
