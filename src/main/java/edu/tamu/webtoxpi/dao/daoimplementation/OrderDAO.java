package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IOrderDAO;
import edu.tamu.webtoxpi.dao.model.Orders;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;

@Repository
public class OrderDAO extends GenericDAOImpl<Orders, Integer> implements IOrderDAO
{
}
