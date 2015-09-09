package edu.tamu.webtoxpi.dao.daoimplementation;

import org.hibernate.Query;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IOrderDAO;
import edu.tamu.webtoxpi.dao.model.Orders;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;

@Repository
public class OrderDAO extends GenericDAOImpl<Orders, Integer> implements IOrderDAO
{
	private final Logger logger = LoggerFactory.getLogger(OrderDAO.class);
	
	public Integer getNextOrderId()
	{
		Integer result = -1;
		try
		{
			Query query = HibernateUtil.getSession().createSQLQuery("select nextval('generateorder_id_seq') as result").addScalar("result", StandardBasicTypes.INTEGER);
			result = ((Integer) query.uniqueResult()).intValue();
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		
		return result;
	}
}
