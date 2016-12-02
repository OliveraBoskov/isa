package session;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import entity.Rating;
import entity.Reservation;
import entity.User;

@Stateless
@Local(RatingDaoLocal.class)
public class RatingDaoBean extends GenericDaoBean<Rating, Integer> implements RatingDaoLocal {

	protected Logger log = Logger.getLogger(RatingDaoBean.class);
	
	
}
