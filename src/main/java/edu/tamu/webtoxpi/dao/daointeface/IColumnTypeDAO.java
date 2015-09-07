package edu.tamu.webtoxpi.dao.daointeface;

import java.util.List;

import edu.tamu.webtoxpi.dao.model.Columntypes;
import edu.tamu.webtoxpi.dao.util.GenericDAO;

public interface IColumnTypeDAO extends GenericDAO<Columntypes, Integer>
{
	public List<Columntypes> selectByProject(String pcode);
}
