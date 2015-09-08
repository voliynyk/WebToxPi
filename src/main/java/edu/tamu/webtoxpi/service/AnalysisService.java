package edu.tamu.webtoxpi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tamu.webtoxpi.dao.entity.Analysis;
import edu.tamu.webtoxpi.dao.model.Results;
import edu.tamu.webtoxpi.service.manager.DAOManager;
import edu.tamu.webtoxpi.service.serviceinterface.IAnalysisService;

@Service("analysisService")
public class AnalysisService implements IAnalysisService
{	
	public Analysis findResultsByProject(Integer id)
	{

		List<Results> results = DAOManager.getInstance().getResultDAO().findResultsByProject(id);
		Analysis analysis = new Analysis();
		if (results.size() > 0)
		{
			
			StringBuilder sResults = new StringBuilder();
			for (Results sResult : results)
			{
				sResults.append(sResult.getStrresult() + ",");
			}
			analysis.setResults(sResults.substring(0, sResults.length() - 1));
		}
		return analysis;
	}	
}
