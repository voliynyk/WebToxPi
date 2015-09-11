package edu.tamu.webtoxpi.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tamu.webtoxpi.dao.entity.Analysis;
import edu.tamu.webtoxpi.dao.model.Components;
import edu.tamu.webtoxpi.dao.model.Results;
import edu.tamu.webtoxpi.service.manager.DAOManager;
import edu.tamu.webtoxpi.service.serviceinterface.IAnalysisService;

@Service("analysisService")
public class AnalysisService implements IAnalysisService
{	
	public Analysis findResultsByProject(Integer id)
	{
		Analysis analysis = new Analysis();
		List<Results> results = DAOManager.getInstance().getResultDAO().findResultsByProject(id);
		List<Components> components = DAOManager.getInstance().getComponentDAO().findComponentByProject(id);
		if (results.size() > 0 && components.size() > 0)
		{
			Collections.sort(results, new Comparator<Results>() {
	
		        public int compare(Results o1, Results o2) {
		            return o1.getOrderId() - o2.getOrderId();
		        }
		    });
			
			ArrayList<Map<String, String>> arrmResults  = new ArrayList<Map<String, String>>();
			 Map<String, String> mResults = new HashMap<String, String>();
			int ordId = results.get(0).getOrderId();
			mResults.put("id", Integer.toString(ordId));
			for(Results result : results) 
			{				
				if (result.getOrderId() != ordId)
				{					
					arrmResults.add(mResults);
					mResults = new HashMap<String, String>();
					ordId = result.getOrderId();
					mResults.put("id", Integer.toString(ordId));
				}
				mResults.put(result.getComponents().getCode(), result.getStrresult());
			}
			arrmResults.add(mResults);
			
			ArrayList<String> arrComponents  = new ArrayList<String>();
			for(Components component : components) 
			{	
				arrComponents.add(component.getCode());
			}

			analysis.setResults(arrmResults.toArray((Map<String, String>[]) new Map[arrmResults.size()]));
		
			analysis.setColumns(arrComponents.toArray(new String[arrComponents.size()]));
			
		}
		
		
		
		return analysis;
	}	
}
