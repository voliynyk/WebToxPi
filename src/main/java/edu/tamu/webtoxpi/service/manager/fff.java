package edu.tamu.webtoxpi.service.manager;

import java.util.ArrayList;
import java.util.List;

import edu.tamu.webtoxpi.dao.daoimplementation.UserDAO;
import edu.tamu.webtoxpi.dao.entity.CUser;
import edu.tamu.webtoxpi.dao.model.Users;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;

public class fff
{
	public List<CUser> all()
	{
		List<CUser> users = new ArrayList<CUser>();
		
		HibernateUtil.beginTransaction();
		UserDAO userDao = new UserDAO();
		
		List<Users> userList = userDao.findAll(Users.class);
		for (Users user : userList)
		{
			users.add(new CUser(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail()));
		}
		HibernateUtil.rollbackTransaction();
		return users;
	}
}
