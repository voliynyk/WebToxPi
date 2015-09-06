package edu.tamu.webtoxpi.dao.daoimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IProjectTypeDAO;
import edu.tamu.webtoxpi.dao.daointeface.IUserDAO;
import edu.tamu.webtoxpi.dao.entity.ProjectType;
import edu.tamu.webtoxpi.dao.entity.User;
import edu.tamu.webtoxpi.dao.model.Projecttypes;
import edu.tamu.webtoxpi.dao.model.Users;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;
import edu.tamu.webtoxpi.utils.DateUtil;

@Repository
public class ProjectTypeDAO extends GenericDAOImpl<Projecttypes, Integer>implements IProjectTypeDAO
{
	public ProjectType convertToEntity(Projecttypes projectType)
	{
		ProjectType result = new ProjectType();
		if (projectType != null)
		{
			result.setId(projectType.getId());
			result.setCode(projectType.getCode());
			result.setName(projectType.getName());
			result.setNotes(projectType.getNotes());
			result.setRegistereddt(projectType.getRegistereddt());
			result.setLastvisitdt(projectType.getLastvisitdt());
		}

		return result;
	}

	public Projecttypes convertToDAO(ProjectType projectType)
	{
		Projecttypes result = null;
		if (projectType.isNew())
		{
			result = new Projecttypes();
			result.setRegistereddt(DateUtil.GetCurrentDate());
			result.setLastvisitdt(DateUtil.GetCurrentDate());
		}
		else
		{
			result = findByID(Projecttypes.class, projectType.getId());
			result.setId(projectType.getId());
			result.setRegistereddt(projectType.getRegistereddt());
			result.setLastvisitdt(projectType.getLastvisitdt());
		}

		if (projectType != null)
		{
			result.setCode(projectType.getCode());
			result.setName(projectType.getName());
			result.setNotes(projectType.getNotes());
		}

		return result;
	}
	
	@Override
	public ProjectType findByID(Integer id)
	{
		Projecttypes projectType = null;
		HibernateUtil.beginTransaction();
		try
		{
			projectType = findByID(Projecttypes.class, id);
		}
		catch (Exception e)
		{
		}
		finally
		{
			HibernateUtil.rollbackTransaction();
		}

		return convertToEntity(projectType);
	}
	
	@Override
	public List<ProjectType> findAll()
	{
		HibernateUtil.beginTransaction();

		List<ProjectType> result = new ArrayList<ProjectType>();
		try
		{
			List<Projecttypes> projectTypes = findAll(Projecttypes.class);
			for (Projecttypes projectType : projectTypes)
			{
				result.add(convertToEntity(projectType));
			}
		}
		finally
		{
			HibernateUtil.rollbackTransaction();
		}
		return result;
	}

	@Override
	public void save(ProjectType user)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ProjectType user)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id)
	{
		// TODO Auto-generated method stub
		
	}
}
