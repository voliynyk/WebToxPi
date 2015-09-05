package edu.tamu.webtoxpi.dao.entity;

public class COrder implements java.io.Serializable
{

	private Integer id;
	private Integer result;
	private Integer rowheader;

	public COrder()
	{
	}

	public COrder(Integer id)
	{
		this.id = id;
	}

	public COrder(Integer id, Integer result, Integer rowheader)
	{
		this.id = id;
		this.result = result;
		this.rowheader = rowheader;
	}

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getResults()
	{
		return this.result;
	}

	public void setResult(Integer result)
	{
		this.result = result;
	}

	public Integer getRowheader()
	{
		return this.rowheader;
	}

	public void setRowheader(Integer rowheader)
	{
		this.rowheader = rowheader;
	}

}
