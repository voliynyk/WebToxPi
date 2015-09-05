package edu.tamu.webtoxpi.dao.entity;

import java.util.Date;

public class CImportInfo implements java.io.Serializable
{

	private Integer id;
	private Integer user;
	private Date transactiondate;
	private String notes;
	private byte[] file;
	private String filename;

	public CImportInfo()
	{
	}

	public CImportInfo(Integer id, Integer user, Date transactiondate, String notes, byte[] file, String filename)
	{
		this.id = id;
		this.user = user;
		this.transactiondate = transactiondate;
		this.notes = notes;
		this.file = file;
		this.filename = filename;
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

	public void setUsers(Integer user)
	{
		this.user = user;
	}

	public Date getTransactiondate()
	{
		return this.transactiondate;
	}

	public void setTransactiondate(Date transactiondate)
	{
		this.transactiondate = transactiondate;
	}

	public String getNotes()
	{
		return this.notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	public byte[] getFile()
	{
		return this.file;
	}

	public void setFile(byte[] file)
	{
		this.file = file;
	}

	public String getFilename()
	{
		return this.filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

}
