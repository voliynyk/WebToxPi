package edu.tamu.webtoxpi.utils.importdata;

public class Components
{
	private String code;
	private Levels level = null;
	
	public Components()
	{
	}
	
	public Components(String code, Levels level)
	{
		this.code = code;
		this.level = level;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public Levels getLevel()
	{
		return level;
	}

	public void setLevel(Levels level)
	{
		this.level = level;
	}
}
