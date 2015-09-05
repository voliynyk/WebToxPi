package edu.tamu.webtoxpi.dao.entity;
// Generated Sep 5, 2015 12:29:29 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Projects generated by hbm2java
 */
public class Projects implements java.io.Serializable
{

	private int id;
	private Users users;
	private String code;
	private String name;
	private int access;
	private String notes;
	private Date registereddt;
	private Date lastvisitdt;
	private Set projectmemberses = new HashSet(0);

	public Projects()
	{
	}

	public Projects(int id, Users users, String code, String name, int access, Date registereddt, Date lastvisitdt)
	{
		this.id = id;
		this.users = users;
		this.code = code;
		this.name = name;
		this.access = access;
		this.registereddt = registereddt;
		this.lastvisitdt = lastvisitdt;
	}

	public Projects(int id, Users users, String code, String name, int access, String notes, Date registereddt, Date lastvisitdt, Set projectmemberses)
	{
		this.id = id;
		this.users = users;
		this.code = code;
		this.name = name;
		this.access = access;
		this.notes = notes;
		this.registereddt = registereddt;
		this.lastvisitdt = lastvisitdt;
		this.projectmemberses = projectmemberses;
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Users getUsers()
	{
		return this.users;
	}

	public void setUsers(Users users)
	{
		this.users = users;
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

	public Set getProjectmemberses()
	{
		return this.projectmemberses;
	}

	public void setProjectmemberses(Set projectmemberses)
	{
		this.projectmemberses = projectmemberses;
	}

}
