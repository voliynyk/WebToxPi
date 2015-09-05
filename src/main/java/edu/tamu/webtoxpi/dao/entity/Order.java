package edu.tamu.webtoxpi.dao.entity;

public class Order implements java.io.Serializable
{

	private Integer id;
	private Integer result;
	private Integer rowheader;

	public Order()
	{
	}

	public Order(Integer id)
	{
		this.id = id;
	}

	public Order(Integer id, Integer result, Integer rowheader)
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
