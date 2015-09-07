package edu.tamu.webtoxpi.dao.daointeface;

import edu.tamu.webtoxpi.dao.model.Columnheaders;
import edu.tamu.webtoxpi.dao.util.GenericDAO;

public interface IColumnHeaderDAO extends GenericDAO<Columnheaders, Integer>
{
	public Columnheaders findByCodeAndProject(String code, String pcode);
}
