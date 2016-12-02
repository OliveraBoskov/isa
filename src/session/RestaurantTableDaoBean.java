package session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entity.RestaurantTable;

@Stateless
@Local(RestaurantTableDaoLocal.class)
public class RestaurantTableDaoBean extends GenericDaoBean<RestaurantTable, Integer> implements RestaurantTableDaoLocal{

}
