package edu.tamu.webtoxpi.service.serviceinterface;

import java.util.List;

import edu.tamu.webtoxpi.dao.entity.User;

public interface IUserService
{
	User findById(Integer id);
	List<User> findAll();
	void saveOrUpdate(User user);
	void delete(int id);
}
