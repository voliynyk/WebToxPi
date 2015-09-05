package edu.tamu.webtoxpi.dao.entity;
// Generated Sep 5, 2015 1:43:34 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

public class CProjectMember implements java.io.Serializable
{

	private int id;
	private Integer project;
	private Integer userroles;
	private Integer users;
	private String notes;
	private Date registereddt;
	private Date lastvisitdt;

	public CProjectMember()
	{
	}

	public CProjectMember(Integer id, Integer projects, Integer userroles, Integer users, Date registereddt, Date lastvisitdt)
	{
		this.id = id;
		this.project = project;
		this.userroles = userroles;
		this.users = users;
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

	public Integer getProject()
	{
		return this.project;
	}

	public void setProject(Integer project)
	{
		this.project = project;
	}

	public Integer getUserroles()
	{
		return this.userroles;
	}

	public void setUserroles(Integer userroles)
	{
		this.userroles = userroles;
	}

	public Integer getUsers()
	{
		return this.users;
	}

	public void setUsers(Integer users)
	{
		this.users = users;
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
