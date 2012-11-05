package controller;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LocationTypeDAO extends HibernateDaoSupport
{
	public void save(LocationType object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void delete(LocationType object)
	{
		getHibernateTemplate().delete(object);
	}

	public Collection find()
	{
		return getHibernateTemplate().find("from LocationType");
	}
}