package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IUserRoleDAO;
import edu.tamu.webtoxpi.dao.model.Userroles;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;

@Repository
public class UserRoleDAO extends GenericDAOImpl<Userroles, Integer> implements IUserRoleDAO
{

}
