package edu.tamu.webtoxpi.dao.daoimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IProjectDAO;
import edu.tamu.webtoxpi.dao.entity.Project;
import edu.tamu.webtoxpi.dao.model.Projects;
import edu.tamu.webtoxpi.dao.model.Projecttypes;
import edu.tamu.webtoxpi.dao.model.Users;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;
import edu.tamu.webtoxpi.service.manager.DAOManager;
import edu.tamu.webtoxpi.utils.Auth;
import edu.tamu.webtoxpi.utils.DateUtil;

@Repository
public class ProjectDAO extends GenericDAOImpl<Projects, Integer> implements IProjectDAO
{
	public Project convertToEntity(Projects project)
	{
		Project result = new Project();
		if (project != null)
		{
			result.setId(project.getId());
			result.setCode(project.getCode());
			result.setName(project.getName());
			result.setAccess(project.getAccess());
			result.setProjecttype(project.getProjecttypes().getId());
		}

		return result;
	}
	
	public Projects convertToDAO(Project project)
	{
		Projects result = null;
		if (project.isNew())
		{
			result = new Projects();
			result.setUsers(Auth.getCurrentUser());
			result.setRegistereddt(DateUtil.GetCurrentDate());
			result.setLastvisitdt(DateUtil.GetCurrentDate());
		}
		else
		{
			result = findByID(Users.class, project.getId());
		}

		if (result != null)
		{
			result.setCode(project.getCode());
			result.setName(project.getName());
			result.setAccess(project.getAccess());
			result.setProjecttypes(DAOManager.getInstance().getProjectTypeDAO().findByID(Projecttypes.class, project.getProjecttype()));
		}
		
		return result;
	}
	
	@Override
	public Project findByID(Integer id)
	{
		Projects project = null;
		try
		{
			HibernateUtil.beginTransaction();
			project = findByID(Projects.class, id);
		}
		catch (Exception e)
		{
		}
		finally
		{
			HibernateUtil.rollbackTransaction();
		}

        return convertToEntity(project);
	}

	@Override
	public List<Project> findAll()
	{
		List<Project> result = new ArrayList<Project>();
		try
		{
			HibernateUtil.beginTransaction();
			List<Projects> projects = findAll(Projects.class);
			for (Projects project : projects)
			{
				result.add(convertToEntity(project));
			}
		}
		catch (Exception e)
		{
		}
		finally
		{
			HibernateUtil.rollbackTransaction();
		}
		return result;
	}

	@Override
	public void save(Project project)
	{
		try
		{
			HibernateUtil.beginTransaction();
			save(convertToDAO(project));
			HibernateUtil.commitTransaction();
		}
		catch (Exception e)
		{
			HibernateUtil.rollbackTransaction();
		}
	}

	@Override
	public void update(Project project)
	{
		try
		{
			HibernateUtil.beginTransaction();
			merge(convertToDAO(project));
			HibernateUtil.commitTransaction();
		}
		catch (Exception e)
		{
			HibernateUtil.rollbackTransaction();
		}
	}

	@Override
	public void delete(int id)
	{
		try
		{
			HibernateUtil.beginTransaction();
			delete(convertToDAO(findByID(id)));
			HibernateUtil.commitTransaction();
		}
		catch (Exception e)
		{
			HibernateUtil.rollbackTransaction();
		}
	}

}
