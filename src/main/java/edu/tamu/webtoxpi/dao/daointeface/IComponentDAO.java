package edu.tamu.webtoxpi.dao.daointeface;

import edu.tamu.webtoxpi.dao.model.Components;
import edu.tamu.webtoxpi.dao.util.GenericDAO;

public interface IComponentDAO extends GenericDAO<Components, Integer>
{
	public Components findByCode(String code);
}
