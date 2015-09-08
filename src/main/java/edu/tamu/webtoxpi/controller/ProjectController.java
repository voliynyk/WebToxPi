package edu.tamu.webtoxpi.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.tamu.webtoxpi.dao.entity.Project;
import edu.tamu.webtoxpi.dao.entity.ProjectType;
import edu.tamu.webtoxpi.service.manager.ProjectTypeManager;
import edu.tamu.webtoxpi.service.serviceinterface.IProjectService;

@Controller

public class ProjectController
{
	private final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	private IProjectService projectService;

	@Autowired
	public void setProjectService(IProjectService projectService)
	{
		this.projectService = projectService;
	}

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String showAllProjects(Model model)
	{
		logger.debug("showAllProjects()");
		model.addAttribute("projects", projectService.findAll());
		return "projects/list";
	}

	@RequestMapping(value = "/projects", method = RequestMethod.POST)
	public String saveOrUpdateProject(@ModelAttribute("projectForm") @Validated Project project, BindingResult result, Model model, final RedirectAttributes redirectAttributes)
	{
		logger.debug("saveOrUpdateProject() : {}", project);

		if (result.hasErrors())
		{
			populateDefaultModel(model);
			return "projects/projectform";
		}
		else
		{

			redirectAttributes.addFlashAttribute("css", "success");
			if (project.isNew())
			{
				redirectAttributes.addFlashAttribute("msg", "Project added successfully!");
			}
			else
			{
				redirectAttributes.addFlashAttribute("msg", "Project updated successfully!");
			}

			projectService.saveOrUpdate(project);

			return "redirect:/projects/" + project.getId();
		}
	}

	// delete project
	@RequestMapping(value = "/projects/{id}/delete", method = RequestMethod.POST)
	public String deleteProject(@PathVariable("id") int id, final RedirectAttributes redirectAttributes)
	{
		logger.debug("deleteProject() : {}", id);

		projectService.delete(id);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Project is deleted!");

		return "redirect:/projects";

	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public String showProject(@PathVariable("id") int id, Model model)
	{

		logger.debug("showProject() id: {}", id);

		Project project = projectService.findById(id);
		if (project == null)
		{
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Project not found");
		}
		model.addAttribute("project", project);

		return "projects/show";

	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex)
	{

		logger.debug("handleEmptyData()");
		logger.error("Request: {}, error ", req.getRequestURL(), ex);

		ModelAndView model = new ModelAndView();
		model.setViewName("project/show");
		model.addObject("msg", "project not found");

		return model;
	}

	// show add project form
	@RequestMapping(value = "/projects/add", method = RequestMethod.GET)
	public String showAddProjectForm(Model model)
	{
		logger.debug("showAddProjectForm()");
		Project project = new Project();
		// set default value
		model.addAttribute("projectForm", project);
		populateDefaultModel(model);
		return "projects/projectform";

	}

	@RequestMapping(value = "/projects/{id}/update", method = RequestMethod.GET)
	public String showUpdateProjectForm(@PathVariable("id") int id, Model model)
	{

		logger.debug("showUpdateProjectForm() : {}", id);

		Project project = projectService.findById(id);
		model.addAttribute("projectForm", project);

		populateDefaultModel(model);

		return "projects/projectform";

	}

//	@RequestMapping(value = "/projects/{id}/select", method = RequestMethod.POST)
//    public String selectProject(@PathVariable("id") int id, Model model, HttpSession session)
//    {
//		Project project = projectService.findById(id);
//		model.addAttribute("projectForm", project);
//		session.setAttribute("projectId" , id);   
//		return "projects/projectform";
//    }
	@RequestMapping(value = "/projects/{id}/select", method = RequestMethod.GET)
    public String selectProject(@PathVariable("id") int id, Model model, HttpServletRequest request)
    {
		Project project = projectService.findById(id);
		model.addAttribute("projectForm", project);
		HttpSession session = request.getSession();
		session.setAttribute("projectId" , id);   
		return "projects/projectform";
    }
	private void populateDefaultModel(Model model)
	{
		Map<Integer, String> access = new LinkedHashMap<Integer, String>();
		access.put(0, "Private");
		access.put(1, "Selected");
		access.put(2, "For registered users (readonly)");
		access.put(3, "For registered users (allow edit)");
		access.put(4, "Public (readonly)");
		access.put(5, "Public (allow edit)");
		model.addAttribute("accessList", access);

		ProjectTypeManager ptm = new ProjectTypeManager();
		Map<Integer, String> projectTypes = new LinkedHashMap<Integer, String>();
		for (ProjectType projectType : ptm.findAll())
		{
			projectTypes.put(projectType.getId(), projectType.getName());
		}
		model.addAttribute("projectTypeList", projectTypes);
	}
}
