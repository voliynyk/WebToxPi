package edu.tamu.webtoxpi.dao.entity;

import java.util.Date;

public class Component implements java.io.Serializable
{
	private Integer id;
	private Integer columnheader;
	private Integer unit;
	private Integer user;
	private String code;
	private String name;
	private String notes;
	private Integer color;
	private Date updateddt;


	public Component()
	{
	}

	public Component(Integer id, Integer columnheader, Integer unit, Integer user, String code, String name, Date updateddt)
	{
		this.id = id;
		this.unit = unit;
		this.user = user;
		this.code = code;
		this.name = name;
		this.updateddt = updateddt;
	}

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Integer getColumnHeader()
	{
		return this.columnheader;
	}

	public void setColumnHeader(Integer columnheader)
	{
		this.columnheader = columnheader;
	}

	public Integer getUnit()
	{
		return this.unit;
	}

	public void setUnits(Integer unit)
	{
		this.unit = unit;
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

	public String getNotes()
	{
		return this.notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	public Integer getColor()
	{
		return this.color;
	}

	public void setColor(Integer color)
	{
		this.color = color;
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
