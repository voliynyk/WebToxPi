package edu.tamu.webtoxpi.dao.daoimplementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IComponentDAO;
import edu.tamu.webtoxpi.dao.model.Components;
import edu.tamu.webtoxpi.dao.model.Results;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;

@Repository
public class ComponentDAO extends GenericDAOImpl<Components, Integer> implements IComponentDAO
{
	private final Logger logger = LoggerFactory.getLogger(ComponentDAO.class);

	public Components findByCodeAndProject(String code, String pcode)
	{
		Components result = null;
		if (StringUtils.isNotBlank(code))
		{
			try
			{
				Query query = HibernateUtil.getSession().getNamedQuery("findComponentsByCodeAndProject").setString("code", code).setString("pcode", pcode);
				List<Components> results = query.list();
				if (results != null && results.size() > 0)
				{
					result = results.get(0);
				}
			}
			catch (Exception e)
			{
				logger.error(e.getMessage(), e);
			}
		}
		return result;
	}
	
	public List<Components> findComponentByProject(Integer id)
	{
		try
		{
			HibernateUtil.beginTransaction();
			
				try
				{
					Query query = HibernateUtil.getSession().getNamedQuery("findComponentsByProject").setInteger("id", id);
					List<Components> components = query.list();
					if (components != null)
					{
						return components;
					}
		
				}
				catch (Exception ex)
				{
					System.out.println(ex.toString());
				}
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			HibernateUtil.rollbackTransaction();
		}
		return new ArrayList();
	}
}
