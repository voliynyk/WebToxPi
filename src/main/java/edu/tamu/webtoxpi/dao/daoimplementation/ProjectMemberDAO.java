package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IProjectMemberDAO;
import edu.tamu.webtoxpi.dao.model.Projectmembers;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;

@Repository
public class ProjectMemberDAO extends GenericDAOImpl<Projectmembers, Integer> implements IProjectMemberDAO
{

}
