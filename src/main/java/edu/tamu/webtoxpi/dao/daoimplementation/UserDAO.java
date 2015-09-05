package edu.tamu.webtoxpi.dao.daoimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointefface.IUserDAO;
import edu.tamu.webtoxpi.dao.entity.User;
import edu.tamu.webtoxpi.dao.model.Users;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;

@Repository
public class UserDAO extends GenericDAOImpl<Users, Integer> implements IUserDAO
{
	public User convertToEntity(Users user)
	{
		User result = new User(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail());
		return result;
	}
	
	public Users convertToDAO(User user)
	{
		Users result = findByID(Users.class, user.getId());
		result.setFirstname(user.getFirstName());
		result.setLastname(user.getLastName());
		result.setEmail(user.getEmail());
		return result;
	}
	
    public User findByID(Integer id)
    {
    	HibernateUtil.beginTransaction();
    	Users user = findByID(Users.class, id);
    	HibernateUtil.rollbackTransaction();
        return convertToEntity(user);
    }

	@Override
	public List<User> findAll()
	{
		HibernateUtil.beginTransaction();
		List<User> result = new ArrayList<User>(); 
		List<Users> users = findAll(Users.class);
		for (Users user : users)
		{
			result.add(convertToEntity(user));
		}
		HibernateUtil.rollbackTransaction();
		return result;
	}

	@Override
	public void save(User user)
	{
		HibernateUtil.beginTransaction();
		save(convertToDAO(user));
		HibernateUtil.commitTransaction();
	}

	@Override
	public void update(User user)
	{
		HibernateUtil.beginTransaction();
		merge(convertToDAO(user));
		HibernateUtil.commitTransaction();
	}

	@Override
	public void delete(int id)
	{
		delete(convertToDAO(findByID(id)));
	}
}
