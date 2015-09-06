package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IResultDAO;
import edu.tamu.webtoxpi.dao.model.Results;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;

@Repository
public class ResultDAO extends GenericDAOImpl<Results, Integer> implements IResultDAO
{
}
