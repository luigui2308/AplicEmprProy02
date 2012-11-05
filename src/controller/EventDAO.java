package controller;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EventDAO extends HibernateDaoSupport
{
	public void save(Event object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void delete(Event object)
	{
		getHibernateTemplate().delete(object);
	}

	public Collection find()
	{
		return getHibernateTemplate().find("from Event");
	}
	
	public Event findByCode(int code)
	{
		return getHibernateTemplate().get(Event.class, code);
	}
	
	public Collection findByPromoter(int code)
	{
		return getHibernateTemplate().find("from Event where promoterId=?", code);
	}
}