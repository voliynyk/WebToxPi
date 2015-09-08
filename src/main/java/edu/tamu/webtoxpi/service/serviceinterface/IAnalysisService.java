package edu.tamu.webtoxpi.service.serviceinterface;

import edu.tamu.webtoxpi.dao.entity.Analysis;

public interface IAnalysisService
{
	Analysis findResultsByProject(Integer id);	
}
