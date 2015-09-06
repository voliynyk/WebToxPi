package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IUnitDAO;
import edu.tamu.webtoxpi.dao.model.Units;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;

@Repository
public class UnitDAO extends GenericDAOImpl<Units, Integer> implements IUnitDAO
{
}
