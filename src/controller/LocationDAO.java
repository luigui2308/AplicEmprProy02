package controller;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LocationDAO extends HibernateDaoSupport
{
	public void save(Location object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void delete(Location object)
	{
		getHibernateTemplate().delete(object);
	}
	
	public void deleteByEvent(int eventCode)
	{
		Collection locations = findByEvent(eventCode);
		for(Object object : locations){
			delete((Location)object);
		}
	}
	
	public Collection findByEvent(int eventCode)
	{
		return getHibernateTemplate().find("from Location where eventId=?", eventCode);
	}
	
	public Location findById(int locationTypeId, int eventCode)
	{
		return (Location)getHibernateTemplate().find("from Location where locationTypeId=? and eventId=?", locationTypeId, eventCode).get(0);
	}

	public Collection find()
	{
		return getHibernateTemplate().find("from Location");
	}
}