package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IViewTemplateDAO;
import edu.tamu.webtoxpi.dao.model.Viewtemplates;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;

@Repository
public class ViewTemplateDAO extends GenericDAOImpl<Viewtemplates, Integer> implements IViewTemplateDAO
{
}
