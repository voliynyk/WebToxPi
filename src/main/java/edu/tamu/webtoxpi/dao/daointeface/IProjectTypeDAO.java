package edu.tamu.webtoxpi.dao.daointeface;

import java.util.List;

import edu.tamu.webtoxpi.dao.entity.ProjectType;
import edu.tamu.webtoxpi.dao.model.Projecttypes;
import edu.tamu.webtoxpi.dao.util.GenericDAO;

public interface IProjectTypeDAO extends GenericDAO<Projecttypes, Integer>
{
	public ProjectType findByID(Integer id);
	public List<ProjectType> findAll();
	public void save(ProjectType user);
	public void update(ProjectType user);
	public void delete(int id);
}
