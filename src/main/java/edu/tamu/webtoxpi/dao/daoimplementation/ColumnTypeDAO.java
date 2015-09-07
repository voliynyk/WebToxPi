package edu.tamu.webtoxpi.dao.daoimplementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IColumnTypeDAO;
import edu.tamu.webtoxpi.dao.model.Columntypes;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;

@Repository
public class ColumnTypeDAO extends GenericDAOImpl<Columntypes, Integer> implements IColumnTypeDAO
{
	private final Logger logger = LoggerFactory.getLogger(ColumnTypeDAO.class);

	@Override
	public List<Columntypes> selectByProject(String pcode)
	{		
		if (StringUtils.isNotBlank(pcode))
		{
			try
			{
				Query query = HibernateUtil.getSession().getNamedQuery("selectColumnTypesByProject").setString("pcode", pcode);
				List<Columntypes> result = query.list();
				if (result != null)
				{
					return result;
				}
	
			}
			catch (Exception e)
			{
				logger.error(e.getMessage(), e);
			}
		}
		return new ArrayList<Columntypes>();
	}
}
