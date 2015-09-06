package edu.tamu.webtoxpi.service.manager;

import java.util.ArrayList;
import java.util.List;

import edu.tamu.webtoxpi.dao.daoimplementation.ProjectTypeDAO;
import edu.tamu.webtoxpi.dao.entity.ProjectType;

public class ProjectTypeManager
{
	public ProjectTypeManager()
	{}
	
	public List<ProjectType> findAll()
	{
		List<ProjectType> result = new ArrayList<ProjectType>();
		
		ProjectTypeDAO projectTypeDAO = DAOManager.getInstance().getProjectTypeDAO();

		for (ProjectType projectType : projectTypeDAO.findAll())
		{
			result.add(projectType);
		}
		return result;
		
	}
}
