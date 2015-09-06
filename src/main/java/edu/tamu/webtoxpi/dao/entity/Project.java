package edu.tamu.webtoxpi.dao.entity;

import java.util.Date;

public class Project implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer user;
	private Integer projectType;
	private String code;
	private String name;
	private Integer access;
	private String notes;
	private Date registereddt;
	private Date lastvisitdt;

	public Project()
	{
	}

	public Project(Integer id, Integer user, Integer projectType, String code, String name, Integer access, Date registereddt, Date lastvisitdt)
	{
		this.id = id;
		this.user = user;
		this.projectType = projectType;
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

	public Integer getProjectType()
	{
		return this.user;
	}

	public void setProjectType(Integer projectType)
	{
		this.projectType = projectType;
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
