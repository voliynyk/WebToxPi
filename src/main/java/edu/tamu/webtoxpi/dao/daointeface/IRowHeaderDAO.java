package edu.tamu.webtoxpi.dao.daointeface;

import edu.tamu.webtoxpi.dao.model.Rowheaders;
import edu.tamu.webtoxpi.dao.util.GenericDAO;

public interface IRowHeaderDAO extends GenericDAO<Rowheaders, Integer>
{
	public Rowheaders findByCodeAndProject(String code, String pcode);
}
