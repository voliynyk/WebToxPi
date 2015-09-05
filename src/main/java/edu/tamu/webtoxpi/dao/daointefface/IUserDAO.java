package edu.tamu.webtoxpi.dao.daointefface;

import java.util.List;

import edu.tamu.webtoxpi.dao.entity.User;
import edu.tamu.webtoxpi.dao.model.Users;
import edu.tamu.webtoxpi.dao.util.GenericDAO;

public interface IUserDAO extends GenericDAO<Users, Integer>
{
	public User findByID(Integer id);
	public List<User> findAll();
	public void save(User user);
	public void update(User user);
	public void delete(int id);
}
