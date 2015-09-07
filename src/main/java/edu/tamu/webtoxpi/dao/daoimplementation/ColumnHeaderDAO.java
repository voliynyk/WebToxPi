package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.tamu.webtoxpi.dao.daointeface.IColumnHeaderDAO;
import edu.tamu.webtoxpi.dao.model.Columnheaders;
import edu.tamu.webtoxpi.dao.model.Rowheaders;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;

@Repository
public class ColumnHeaderDAO extends GenericDAOImpl<Columnheaders, Integer> implements IColumnHeaderDAO
{
	private final Logger logger = LoggerFactory.getLogger(ColumnHeaderDAO.class);
}
