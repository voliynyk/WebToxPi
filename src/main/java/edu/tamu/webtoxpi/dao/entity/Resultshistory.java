package edu.tamu.webtoxpi.dao.entity;
// Generated Sep 5, 2015 12:29:29 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * Resultshistory generated by hbm2java
 */
public class Resultshistory implements java.io.Serializable
{

	private int id;
	private Results results;
	private Users users;
	private String oldstrresult;
	private String newstrresult;
	private Date updateddt;

	public Resultshistory()
	{
	}

	public Resultshistory(int id, Results results, Users users, Date updateddt)
	{
		this.id = id;
		this.results = results;
		this.users = users;
		this.updateddt = updateddt;
	}

	public Resultshistory(int id, Results results, Users users, String oldstrresult, String newstrresult, Date updateddt)
	{
		this.id = id;
		this.results = results;
		this.users = users;
		this.oldstrresult = oldstrresult;
		this.newstrresult = newstrresult;
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

	public Results getResults()
	{
		return this.results;
	}

	public void setResults(Results results)
	{
		this.results = results;
	}

	public Users getUsers()
	{
		return this.users;
	}

	public void setUsers(Users users)
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
