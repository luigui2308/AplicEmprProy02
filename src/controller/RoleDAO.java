package controller;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RoleDAO extends HibernateDaoSupport
{
	public void save(Role object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void delete(Role object)
	{
		getHibernateTemplate().delete(object);
	}

	public Collection find()
	{
		return getHibernateTemplate().find("from Role");
	}
}