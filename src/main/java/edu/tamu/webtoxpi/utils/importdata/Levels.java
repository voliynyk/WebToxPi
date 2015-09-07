package edu.tamu.webtoxpi.utils.importdata;

public class Levels
{
	private Levels childLevel;
	private String code;
	
	public Levels()
	{
	}
	
	public Levels(Levels childLevel, String code)
	{
		this.childLevel = childLevel;
		this.code = code;
	}

	public Levels getChildLevel()
	{
		return childLevel;
	}

	public void setChildLevel(Levels childLevel)
	{
		this.childLevel = childLevel;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}
}
