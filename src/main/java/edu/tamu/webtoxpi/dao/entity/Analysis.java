package edu.tamu.webtoxpi.dao.entity;

public class Analysis
{
	private Integer id;
	private String results;	
	
	public Analysis()
	{}
	
	public Analysis(Integer id, String results)
	{
		super();
		this.id = id;
		this.results = results;		
	}
	
	public boolean isNew() {
		return (this.id == null);
	}
	
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getResults()
	{
		return results;
	}

	public void setResults(String results)
	{
		this.results = results;
	}	
}
