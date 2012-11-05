package controller;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NumberedLocationDAO extends HibernateDaoSupport
{
	public void save(NumberedLocation object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void delete(NumberedLocation object)
	{
		getHibernateTemplate().delete(object);
	}

	public Collection find()
	{
		return getHibernateTemplate().find("from NumberedLocation");
	}
	
	public Collection findByTicketCode(int ticketCode)
	{
		return getHibernateTemplate().find("from NumberedLocation where ticketId=?", ticketCode);
	}
}