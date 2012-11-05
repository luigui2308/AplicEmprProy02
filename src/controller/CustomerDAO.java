package controller;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CustomerDAO extends HibernateDaoSupport
{
	public void save(Customer object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void delete(Customer object)
	{
		getHibernateTemplate().delete(object);
	}

	public Collection find()
	{
		return getHibernateTemplate().find("from Customer");
	}
	
	public Customer findById(String id)
	{
		return (Customer)getHibernateTemplate().get(Customer.class, id);
	}
}