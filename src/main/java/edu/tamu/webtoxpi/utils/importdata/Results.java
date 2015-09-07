package edu.tamu.webtoxpi.utils.importdata;

import java.util.ArrayList;
import java.util.List;

public class Results
{
	private String value;
	private Components component;
	private List<String> rows = new ArrayList<String>();
	
	public Results()
	{
	}
	
	public Results(String value, Components component, List<String> rows)
	{
		this.value = value;
		this.component = component;
		this.rows = rows;
	}
	
	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
	
	public Components getComponent()
	{
		return component;
	}

	public void setComponent(Components component)
	{
		this.component = component;
	}

	public List<String> getRows()
	{
		return rows;
	}

	public void setRows(List<String> rows)
	{
		this.rows = rows;
	}
}
