package edu.tamu.webtoxpi.dao.daoimplementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IRowTypeDAO;
import edu.tamu.webtoxpi.dao.model.Rowheaders;
import edu.tamu.webtoxpi.dao.model.Rowtypes;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;

@Repository
public class RowTypeDAO extends GenericDAOImpl<Rowtypes, Integer> implements IRowTypeDAO
{
	private final Logger logger = LoggerFactory.getLogger(RowTypeDAO.class);
	
	public Rowtypes findByCodeAndProject(String code, String pcode)
	{
		Rowtypes result = null;
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(pcode))
		{
			try
			{
				Query query = HibernateUtil.getSession().getNamedQuery("findRowTypesByCodeAndProject").setString("code", code).setString("pcode", pcode);
				List<Rowtypes> results = query.list();
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
	
	public List<Rowtypes> selectByProject(String pcode)
	{		
		if (StringUtils.isNotBlank(pcode))
		{
			try
			{
				Query query = HibernateUtil.getSession().getNamedQuery("selectRowTypesByProject").setString("pcode", pcode);
				List<Rowtypes> types = query.list();
				if (types != null)
				{
					return types;
				}
	
			}
			catch (Exception e)
			{
				logger.error(e.getMessage(), e);
			}
		}
		return new ArrayList<Rowtypes>();
	}
}
