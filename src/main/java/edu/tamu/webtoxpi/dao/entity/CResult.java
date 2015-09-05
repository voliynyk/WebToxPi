package edu.tamu.webtoxpi.dao.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class CResult implements java.io.Serializable
{

	private int id;
	private Integer components;
	private Integer users;
	private String strresult;
	private Date updateddt;

	public CResult()
	{
	}

	public CResult(int id, Integer components, Integer users, Date updateddt)
	{
		this.id = id;
		this.components = components;
		this.users = users;
		this.updateddt = updateddt;
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Integer getComponents()
	{
		return this.components;
	}

	public void setComponents(Integer components)
	{
		this.components = components;
	}

	public Integer getUsers()
	{
		return this.users;
	}

	public void setUsers(Integer users)
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
}
