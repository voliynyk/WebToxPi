package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.tamu.webtoxpi.dao.daointeface.IRowHeaderDAO;
import edu.tamu.webtoxpi.dao.model.Rowheaders;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;

@Repository
public class RowHeaderDAO extends GenericDAOImpl<Rowheaders, Integer> implements IRowHeaderDAO
{
	private final Logger logger = LoggerFactory.getLogger(RowHeaderDAO.class);
	
	public Rowheaders findByCodeAndProject(String code, String pcode)
	{
		Rowheaders result = null;
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(pcode))
		{
			try
			{
				Query query = HibernateUtil.getSession().getNamedQuery("findRowHeadersByCodeAndProject").setString("code", code).setString("pcode", pcode);
				List<Rowheaders> results = query.list();
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
