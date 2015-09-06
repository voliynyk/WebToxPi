package edu.tamu.webtoxpi.dao.daoimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IProjectDAO;
import edu.tamu.webtoxpi.dao.entity.Project;
import edu.tamu.webtoxpi.dao.model.Projects;
import edu.tamu.webtoxpi.dao.model.Users;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;

@Repository
public class ProjectDAO extends GenericDAOImpl<Projects, Integer> implements IProjectDAO
{
	public Project convertToEntity(Projects project)
	{
		Project result = new Project(project.getId(), project.getUsers().getId(), project.getProjecttypes().getId(), project.getCode(), project.getName(), project.getAccess(), project.getRegistereddt(), project.getLastvisitdt());
		return result;
	}
	
	public Projects convertToDAO(Project project)
	{
		Projects result = findByID(Users.class, project.getId());
		result.setCode(project.getCode());
		result.setName(project.getName());
		result.setAccess(project.getAccess());
		return result;
	}
	
	@Override
	public Project findByID(Integer id)
	{
    	HibernateUtil.beginTransaction();
    	Projects project = findByID(Projects.class, id);
    	HibernateUtil.rollbackTransaction();
        return convertToEntity(project);
	}

	@Override
	public List<Project> findAll()
	{
		HibernateUtil.beginTransaction();
		List<Project> result = new ArrayList<Project>(); 
		List<Projects> projects = findAll(Projects.class);
		for (Projects project : projects)
		{
			result.add(convertToEntity(project));
		}
		HibernateUtil.rollbackTransaction();
		return result;
	}

	@Override
	public void save(Project project)
	{
		HibernateUtil.beginTransaction();
		Projects result = new Projects();
		result.setCode(project.getCode());
		result.setName(project.getName());
		result.setAccess(project.getAccess());
		save(result);
		HibernateUtil.commitTransaction();
	}

	@Override
	public void update(Project project)
	{
		HibernateUtil.beginTransaction();
		merge(convertToDAO(project));
		HibernateUtil.commitTransaction();
	}

	@Override
	public void delete(int id)
	{
		delete(convertToDAO(findByID(id)));
	}

}
