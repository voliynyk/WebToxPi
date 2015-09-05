package edu.tamu.webtoxpi.dao.entity;

import java.util.Date;

public class CResultsHistory implements java.io.Serializable
{

	private int id;
	private Integer results;
	private Integer users;
	private String oldstrresult;
	private String newstrresult;
	private Date updateddt;

	public CResultsHistory()
	{
	}

	public CResultsHistory(int id, Integer results, Integer users, Date updateddt)
	{
		this.id = id;
		this.results = results;
		this.users = users;
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

	public Integer getResults()
	{
		return this.results;
	}

	public void setResults(Integer results)
	{
		this.results = results;
	}

	public Integer getUsers()
	{
		return this.users;
	}

	public void setUsers(Integer users)
	{
		this.users = users;
	}

	public String getOldstrresult()
	{
		return this.oldstrresult;
	}

	public void setOldstrresult(String oldstrresult)
	{
		this.oldstrresult = oldstrresult;
	}

	public String getNewstrresult()
	{
		return this.newstrresult;
	}

	public void setNewstrresult(String newstrresult)
	{
		this.newstrresult = newstrresult;
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
