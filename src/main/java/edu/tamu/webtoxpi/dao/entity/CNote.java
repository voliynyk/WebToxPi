package edu.tamu.webtoxpi.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class CNote implements java.io.Serializable
{

	private Integer id;
	private Integer user;
	private String code;
	private String note;
	private int ownerId;
	private Serializable ownertype;
	private boolean visible;
	private Date updateddt;

	public CNote()
	{
	}

	public CNote(Integer id, Integer user, String code, Integer ownerId, Serializable ownertype, boolean visible, Date updateddt)
	{
		this.id = id;
		this.user = user;
		this.code = code;
		this.ownerId = ownerId;
		this.ownertype = ownertype;
		this.visible = visible;
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

	public String getNote()
	{
		return this.note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public int getOwnerId()
	{
		return this.ownerId;
	}

	public void setOwnerId(int ownerId)
	{
		this.ownerId = ownerId;
	}

	public Serializable getOwnertype()
	{
		return this.ownertype;
	}

	public void setOwnertype(Serializable ownertype)
	{
		this.ownertype = ownertype;
	}

	public boolean isVisible()
	{
		return this.visible;
	}

	public void setVisible(boolean visible)
	{
		this.visible = visible;
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
