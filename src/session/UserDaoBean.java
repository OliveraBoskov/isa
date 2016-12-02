package session;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import entity.User;

@Stateless
@Local(UserDaoLocal.class)
public class UserDaoBean extends GenericDaoBean<User, Integer> implements UserDaoLocal{
	
	protected Logger log = Logger.getLogger(UserDaoBean.class);
	
	@Override
	public User findUserWithEmail(String email) {
		Query q = em
				.createNamedQuery("findUserWithEmail");
		q.setParameter("email", email);
		User result = null;
		
		try {
			result = (User) q.getSingleResult();
		}
		catch(NoResultException e) {
			log.info("No result for email: " + email);
		}
		
		return result;
	}

	@Override
	public User findUserWithEmailAndPassword(String email, String password) {
		Query q = em
				.createNamedQuery("findUserWithEmailAndPassword");
		q.setParameter("email", email);
		q.setParameter("password", password);
		
		User result = null;
		
		try {
			result = (User) q.getSingleResult();
		}
		catch(NoResultException e) {
			log.info("No result for email: " + email + " and password: " + password);
		}
		
		return result;
	}
}
