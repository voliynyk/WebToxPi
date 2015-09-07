package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.tamu.webtoxpi.dao.daointeface.IColumnHeaderDAO;
import edu.tamu.webtoxpi.dao.model.Columnheaders;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;

@Repository
public class ColumnHeaderDAO extends GenericDAOImpl<Columnheaders, Integer> implements IColumnHeaderDAO
{
	private final Logger logger = LoggerFactory.getLogger(ColumnHeaderDAO.class);
	
	public Columnheaders findByCodeAndProject(String code, String pcode)
	{
		Columnheaders result = null;
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(pcode))
		{
			try
			{
				Query query = HibernateUtil.getSession().getNamedQuery("findColumnHeadersByCodeAndProject").setString("code", code).setString("pcode", pcode);
				List<Columnheaders> results = query.list();
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
}
