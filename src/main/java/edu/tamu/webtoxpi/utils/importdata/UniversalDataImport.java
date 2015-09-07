package edu.tamu.webtoxpi.utils.importdata;

import java.util.ArrayList;
import java.util.List;

public class UniversalDataImport
{
	private List<Results> results  = new ArrayList<Results>();
	
	public UniversalDataImport()
	{
	}
	
	public List<Results> getResults()
	{
		return results;
	}

	public void setResults(List<Results> results)
	{
		this.results = results;
	}

	public UniversalDataImport(List<Results> results)
	{
		this.results = results;
	}

}
