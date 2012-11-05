package controller;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TicketDAO extends HibernateDaoSupport
{
	public void save(Ticket object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void delete(Ticket object)
	{
		getHibernateTemplate().delete(object);
	}

	public Collection find()
	{
		return getHibernateTemplate().find("from Ticket");
	}
	
	public Collection findByEvent(int eventCode)
	{
		return getHibernateTemplate().find("from Ticket where eventId=?", eventCode);
	}
	
	public Collection findByEventAndLocation(int eventCode, int locationTypeId)
	{
		return getHibernateTemplate().find("from Ticket where locationTypeId=? and eventId=?", locationTypeId, eventCode);
	}
	
	public Ticket findByCode(int code)
	{
		return getHibernateTemplate().get(Ticket.class, new Integer(code));
	}
}