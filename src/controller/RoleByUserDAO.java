package controller;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RoleByUserDAO extends HibernateDaoSupport
{
	public void save(RoleByUser object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}

	public void delete(RoleByUser object)
	{
		getHibernateTemplate().delete(object);
	}

	public Collection find()
	{
		return getHibernateTemplate().find("from RoleByUser");
	}

	public Collection findByUsername(String username)
	{
		return getHibernateTemplate().find("from RoleByUser where username = ?", username);
	}
}