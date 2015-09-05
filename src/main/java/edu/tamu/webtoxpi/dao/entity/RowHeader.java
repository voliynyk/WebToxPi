package edu.tamu.webtoxpi.dao.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class RowHeader implements java.io.Serializable
{

	private int id;
	private Integer rowtypes;
	private String code;
	private String name;
	private String notes;
	private Date registereddt;
	private Date lastvisitdt;
	private Set orderses = new HashSet(0);

	public RowHeader()
	{
	}

	public RowHeader(int id, Integer rowtypes, String code, String name, Date registereddt, Date lastvisitdt)
	{
		this.id = id;
		this.rowtypes = rowtypes;
		this.code = code;
		this.name = name;
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

	public Integer getRowtypes()
	{
		return this.rowtypes;
	}

	public void setRowtypes(Integer rowtypes)
	{
		this.rowtypes = rowtypes;
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

	public Set getOrderses()
	{
		return this.orderses;
	}

	public void setOrderses(Set orderses)
	{
		this.orderses = orderses;
	}

}
