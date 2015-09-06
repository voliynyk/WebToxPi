package edu.tamu.webtoxpi.service.serviceinterface;

import java.util.List;

import edu.tamu.webtoxpi.dao.entity.Project;

public interface IProjectService
{
	Project findById(Integer id);
	List<Project> findAll();
	void saveOrUpdate(Project project);
	void delete(int id);
}
