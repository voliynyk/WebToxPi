package edu.tamu.webtoxpi.dao.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Project implements java.io.Serializable
{
	private int id;
	private Integer user;
	private String code;
	private String name;
	private Integer access;
	private String notes;
	private Date registereddt;
	private Date lastvisitdt;

	public Project()
	{
	}

	public Project(int id, Integer user, String code, String name, int access, Date registereddt, Date lastvisitdt)
	{
		this.id = id;
		this.user = user;
		this.code = code;
		this.name = name;
		this.access = access;
		this.registereddt = registereddt;
		this.lastvisitdt = lastvisitdt;
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Integer getUser()
	{
		return this.user;
	}

	public void setUser(Integer user)
	{
		this.user = user;
	}

	public String getCode()
	{
		return this.code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAccess()
	{
		return this.access;
	}

	public void setAccess(int access)
	{
		this.access = access;
	}

	public String getNotes()
	{
		return this.notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	public Date getRegistereddt()
	{
		return this.registereddt;
	}

	public void setRegistereddt(Date registereddt)
	{
		this.registereddt = registereddt;
	}

	public Date getLastvisitdt()
	{
		return this.lastvisitdt;
	}

	public void setLastvisitdt(Date lastvisitdt)
	{
		this.lastvisitdt = lastvisitdt;
	}
}
