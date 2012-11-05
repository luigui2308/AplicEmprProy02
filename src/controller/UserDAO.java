package controller;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDAO extends HibernateDaoSupport
{
	public void save(User object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void delete(User object)
	{
		getHibernateTemplate().delete(object);
	}

	public Collection find()
	{
		return getHibernateTemplate().find("from User");
	}
	
	public User findByUsername(String username)
	{
		return (User)getHibernateTemplate().get(User.class, username);
	}
}