package session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entity.MenuItem;

@Stateless
@Local(MenuItemDaoLocal.class)
public class MenuItemDaoBean extends GenericDaoBean<MenuItem, Integer> implements MenuItemDaoLocal{

}
