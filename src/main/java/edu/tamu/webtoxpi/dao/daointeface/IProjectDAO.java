package edu.tamu.webtoxpi.dao.daointeface;

import java.util.List;

import edu.tamu.webtoxpi.dao.entity.Project;
import edu.tamu.webtoxpi.dao.model.Projects;
import edu.tamu.webtoxpi.dao.util.GenericDAO;

public interface IProjectDAO extends GenericDAO<Projects, Integer>
{
	public Project findByID(Integer id);
	public List<Project> findAll();
	public void save(Project project);
	public void update(Project project);
	public void delete(int id);
}
