package controller;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EventTypeDAO extends HibernateDaoSupport
{
	public void save(EventType object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void delete(EventType object)
	{
		getHibernateTemplate().delete(object);
	}

	public Collection find()
	{
		return getHibernateTemplate().find("from EventType");
	}
}