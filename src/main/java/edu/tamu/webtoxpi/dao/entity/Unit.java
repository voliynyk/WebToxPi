package edu.tamu.webtoxpi.dao.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Unit implements java.io.Serializable
{

	private Integer id;
	private Integer units;
	private Integer users;
	private String code;
	private String name;
	private BigDecimal volumeof;
	private Date updateddt;

	public Unit()
	{
	}

	public Unit(int id, Integer users, String code, Date updateddt)
	{
		this.id = id;
		this.users = users;
		this.code = code;
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

	public Integer getUnits()
	{
		return this.units;
	}

	public void setUnits(Integer units)
	{
		this.units = units;
	}

	public Integer getUsers()
	{
		return this.users;
	}

	public void setUsers(Integer users)
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

	public BigDecimal getVolumeof()
	{
		return this.volumeof;
	}

	public void setVolumeof(BigDecimal volumeof)
	{
		this.volumeof = volumeof;
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
