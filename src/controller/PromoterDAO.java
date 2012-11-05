package controller;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PromoterDAO extends HibernateDaoSupport
{
	public void save(Promoter object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void delete(Promoter object)
	{
		getHibernateTemplate().delete(object);
	}

	public Collection find()
	{
		return getHibernateTemplate().find("from Promoter");
	}
	
	public Promoter findByCode(int code)
	{
		return getHibernateTemplate().get(Promoter.class, code);
	}
	
	public Promoter findByUsername(String username)
	{
		return (Promoter)getHibernateTemplate().find("from Promoter where username=?", username).get(0);
	}
}