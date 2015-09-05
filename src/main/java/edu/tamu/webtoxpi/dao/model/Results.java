package edu.tamu.webtoxpi.dao.model;
// Generated Sep 5, 2015 1:43:34 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Results generated by hbm2java
 */
public class Results implements java.io.Serializable
{

	private int id;
	private Components components;
	private Users users;
	private String strresult;
	private Date updateddt;
	private Set resultshistories = new HashSet(0);
	private Set orderses = new HashSet(0);

	public Results()
	{
	}

	public Results(int id, Components components, Users users, Date updateddt)
	{
		this.id = id;
		this.components = components;
		this.users = users;
		this.updateddt = updateddt;
	}

	public Results(int id, Components components, Users users, String strresult, Date updateddt, Set resultshistories, Set orderses)
	{
		this.id = id;
		this.components = components;
		this.users = users;
		this.strresult = strresult;
		this.updateddt = updateddt;
		this.resultshistories = resultshistories;
		this.orderses = orderses;
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Components getComponents()
	{
		return this.components;
	}

	public void setComponents(Components components)
	{
		this.components = components;
	}

	public Users getUsers()
	{
		return this.users;
	}

	public void setUsers(Users users)
	{
		this.users = users;
	}

	public String getStrresult()
	{
		return this.strresult;
	}

	public void setStrresult(String strresult)
	{
		this.strresult = strresult;
	}

	public Date getUpdateddt()
	{
		return this.updateddt;
	}

	public void setUpdateddt(Date updateddt)
	{
		this.updateddt = updateddt;
	}

	public Set getResultshistories()
	{
		return this.resultshistories;
	}

	public void setResultshistories(Set resultshistories)
	{
		this.resultshistories = resultshistories;
	}

	public Set getOrderses()
	{
		return this.orderses;
	}

	public void setOrderses(Set orderses)
	{
		this.orderses = orderses;
	}

}
