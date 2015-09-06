package edu.tamu.webtoxpi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tamu.webtoxpi.dao.daointeface.IProjectDAO;
import edu.tamu.webtoxpi.dao.entity.Project;
import edu.tamu.webtoxpi.service.serviceinterface.IProjectService;

@Service("projectService")
public class ProjectService implements IProjectService
{
	IProjectDAO projectDAO;
	
	@Autowired
	public void setProjectService(IProjectDAO projectDao)
	{
		this.projectDAO = projectDao;
	}

	public Project findById(Integer id)
	{
		return projectDAO.findByID(id);
	}

	public List<Project> findAll()
	{
		return projectDAO.findAll();
	}

	public void saveOrUpdate(Project project)
	{
		if (project.isNew())
		{
			projectDAO.save(project);
		}
		else
		{
			projectDAO.update(project);
		}
	}

	public void delete(int id)
	{
		projectDAO.delete(id);
	}
}