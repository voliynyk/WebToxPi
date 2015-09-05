package edu.tamu.webtoxpi.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class CViewTemplate implements java.io.Serializable
{

	private Integer id;
	private Integer usersByUpdatedby;
	private Integer usersByUserId;
	private String code;
	private String name;
	private Serializable objectxml;
	private Date updateddt;

	public CViewTemplate()
	{
	}

	public CViewTemplate(Integer id, Integer usersByUpdatedby, Integer usersByUserId, String code, String name, Date updateddt)
	{
		this.id = id;
		this.usersByUpdatedby = usersByUpdatedby;
		this.usersByUserId = usersByUserId;
		this.code = code;
		this.name = name;
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

	public Integer getUsersByUpdatedby()
	{
		return this.usersByUpdatedby;
	}

	public void setUsersByUpdatedby(Integer usersByUpdatedby)
	{
		this.usersByUpdatedby = usersByUpdatedby;
	}

	public Integer getUsersByUserId()
	{
		return this.usersByUserId;
	}

	public void setUsersByUserId(Integer usersByUserId)
	{
		this.usersByUserId = usersByUserId;
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

	public Serializable getObjectxml()
	{
		return this.objectxml;
	}

	public void setObjectxml(Serializable objectxml)
	{
		this.objectxml = objectxml;
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
