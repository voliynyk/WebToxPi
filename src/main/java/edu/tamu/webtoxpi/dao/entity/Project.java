package edu.tamu.webtoxpi.dao.entity;

import java.util.Date;

public class Project implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer user;
	private Integer projecttype;
	private String code;
	private String name;
	private Integer access;
	private String notes;
	private Date registereddt;
	private Date lastvisitdt;
	private String[] projectmanagers;
	private String[] projectmembers;
	private String[] projectreviewers;

	public Project()
	{
	}

	public Project(Integer id, Integer user, Integer projecttype, String code, String name, Integer access, Date registereddt, Date lastvisitdt)
	{
		this.id = id;
		this.user = user;
		this.projecttype = projecttype;
		this.code = code;
		this.name = name;
		this.access = access;
		this.registereddt = registereddt;
		this.lastvisitdt = lastvisitdt;
	}
	
	public boolean isNew() {
		return (this.id == null);
	}

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String[] getProjectmanagers()
	{
		return this.projectmanagers;
	}

	public void setProjectmanagers(String[] projectmanagers)
	{
		this.projectmanagers = projectmanagers;
	}
	
	public String[] getProjectmembers()
	{
		return this.projectmembers;
	}

	public void setProjectmembers(String[] projectmembers)
	{
		this.projectmembers = projectmembers;
	}
	
	public String[] getProjectreviewers()
	{
		return this.projectreviewers;
	}

	public void setProjectreviewers(String[] projectreviewers)
	{
		this.projectreviewers = projectreviewers;
	}

	public Integer getProjecttype()
	{
		return this.projecttype;
	}

	public void setProjecttype(Integer projecttype)
	{
		this.projecttype = projecttype;
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

	public Integer getAccess()
	{
		return this.access;
	}

	public void setAccess(Integer access)
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
