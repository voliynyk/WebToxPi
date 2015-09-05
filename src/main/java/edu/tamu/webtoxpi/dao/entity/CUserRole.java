package edu.tamu.webtoxpi.dao.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CUserRole implements java.io.Serializable
{

	private Integer id;
	private String code;
	private String name;
	private String notes;
	private Date registereddt;
	private Date lastvisitdt;
	private Set projectmemberses = new HashSet(0);

	public CUserRole()
	{
	}

	public CUserRole(Integer id, String code, String name, Date registereddt, Date lastvisitdt)
	{
		this.id = id;
		this.code = code;
		this.name = name;
		this.registereddt = registereddt;
		this.lastvisitdt = lastvisitdt;
	}


	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
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
