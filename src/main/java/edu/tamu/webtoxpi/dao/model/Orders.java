package edu.tamu.webtoxpi.dao.model;
// Generated Sep 5, 2015 1:43:34 PM by Hibernate Tools 4.3.1.Final

/**
 * Orders generated by hbm2java
 */
public class Orders implements java.io.Serializable
{

	private int id;
	private Rowheaders rowheaders;
	private int orderId;

	public Orders()
	{
	}

	public Orders(int id, Rowheaders rowheaders, int orderId)
	{
		this.id = id;
		this.rowheaders = rowheaders;
		this.orderId = orderId;
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Rowheaders getRowheaders()
	{
		return this.rowheaders;
	}

	public void setRowheaders(Rowheaders rowheaders)
	{
		this.rowheaders = rowheaders;
	}

	public int getOrderId()
	{
		return this.orderId;
	}

	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}

}
