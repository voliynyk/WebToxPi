package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IComponentDAO;
import edu.tamu.webtoxpi.dao.model.Components;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;

@Repository
public class ComponentDAO extends GenericDAOImpl<Components, Integer> implements IComponentDAO
{
}
