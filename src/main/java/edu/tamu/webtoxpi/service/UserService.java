package edu.tamu.webtoxpi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tamu.webtoxpi.dao.daoimplementation.UserDAO;
import edu.tamu.webtoxpi.dao.daointefface.IUserDAO;
import edu.tamu.webtoxpi.dao.entity.User;

@Service("userService")
public class UserService implements IUserService
{
	IUserDAO userDAO;

	@Autowired
	public void setUserDao(IUserDAO userDao)
	{
		this.userDAO = userDao;
	}

	public User findById(Integer id)
	{
		return userDAO.findByID(id);
	}

	public List<User> findAll()
	{
		return userDAO.findAll();
	}

	public void saveOrUpdate(User user)
	{

		if (findById(user.getId()) == null)
		{
			userDAO.save(user);
		}
		else
		{
			userDAO.update(user);
		}

	}

	public void delete(int id)
	{
		userDAO.delete(id);
	}

}
