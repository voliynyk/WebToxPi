package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

import edu.tamu.webtoxpi.dao.daointeface.IResultDAO;
import edu.tamu.webtoxpi.dao.model.Results;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class ResultDAO extends GenericDAOImpl<Results, Integer> implements IResultDAO
{
	public List<Results> findResultsByProject(Integer id)
	{
		try
		{
			HibernateUtil.beginTransaction();
			
				try
				{
					Query query = HibernateUtil.getSession().getNamedQuery("findResultsByProject").setInteger("id", id);
					List<Results> results = query.list();
					if (results != null)
					{
						return results;
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
