package edu.tamu.webtoxpi.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.tamu.webtoxpi.dao.entity.Analysis;
import edu.tamu.webtoxpi.service.serviceinterface.IAnalysisService;


@Controller
public class AnalysisController
{

	private final Logger logger = LoggerFactory.getLogger(AnalysisController.class);

	
	private IAnalysisService analysisService;

	@Autowired
	public void setAnalysisService(IAnalysisService analysisService)
	{
		this.analysisService = analysisService;
	}

	@RequestMapping(value = "/analysis/{id}", method = RequestMethod.GET)
	public String showAnalysis(@PathVariable("id") int id, Model model)
	{

		logger.debug("showAnalysis() project id: {}", id);

		Analysis analysis = analysisService.findResultsByProject(id);
		if (analysis == null)
		{
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Results not found");
		}
		model.addAttribute("analysis", analysis);

		return "analysis/show";

	}
}
