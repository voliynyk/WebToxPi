package edu.tamu.webtoxpi.dao.daoimplementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IUserDAO;
import edu.tamu.webtoxpi.dao.entity.User;
import edu.tamu.webtoxpi.dao.model.Users;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;
import edu.tamu.webtoxpi.dao.util.HibernateUtil;
import edu.tamu.webtoxpi.utils.DateUtil;

@Repository
public class UserDAO extends GenericDAOImpl<Users, Integer>implements IUserDAO
{
	public User convertToEntity(Users user)
	{
		User result = new User();
		if (user != null)
		{
			result.setId(user.getId());
			result.setLogin(user.getLogin());
			result.setPassword(user.getPassword());
			result.setFirstname(user.getFirstname());
			result.setLastname(user.getLastname());
			result.setEmail(user.getEmail());
			result.setPhone(user.getPhone());
			result.setAddress1(user.getAddress1());
			result.setAddress2(user.getAddress2());
			result.setCountry(user.getCountry());

			result.setState(user.getState());
			result.setZip(user.getZip());
			result.setSex(user.getSex());
			result.setOrganization(user.getOrganization());
			result.setOrganaddress(user.getOrganaddress());
			result.setNotes(user.getNotes());
		}

		return result;
	}

	public Users convertToDAO(User user)
	{
		Users result = null;
		if (user.isNew())
		{
			result = new Users();
			result.setRegistereddt(DateUtil.GetCurrentDate());
			result.setLastvisitdt(DateUtil.GetCurrentDate());
		}
		else
		{
			result = findByID(Users.class, user.getId());
			result.setRegistereddt(user.getRegistereddt());
			result.setLastvisitdt(user.getLastvisitdt());
		}

		if (user != null)
		{
			result.setLogin(user.getLogin());
			result.setPassword(user.getPassword());
			result.setFirstname(user.getFirstname());
			result.setLastname(user.getLastname());
			result.setEmail(user.getEmail());
			result.setPhone(user.getPhone());
			result.setAddress1(user.getAddress1());
			result.setAddress2(user.getAddress2());
			result.setCountry(user.getCountry());
			result.setState(user.getState());
			result.setZip(user.getZip());
			result.setSex(user.getSex());
			result.setOrganization(user.getOrganization());
			result.setOrganaddress(user.getOrganaddress());
			result.setNotes(user.getNotes());
		}

		return result;
	}

	public User findByID(Integer id)
	{
		Users user = null;
		
		try
		{
			HibernateUtil.beginTransaction();
			user = findByID(Users.class, id);
		}
		catch (Exception e)
		{
		}
		finally
		{
			HibernateUtil.rollbackTransaction();
		}

		return convertToEntity(user);
	}

	@Override
	public List<User> findAll()
	{
		List<User> result = new ArrayList<User>();
		try
		{
			HibernateUtil.beginTransaction();
			List<Users> users = findAll(Users.class);
			for (Users user : users)
			{
				result.add(convertToEntity(user));
			}
		}
		catch (Exception e)
		{

		}
		finally
		{
			HibernateUtil.rollbackTransaction();
		}
		return result;
	}

	@Override
	public void save(User user)
	{
		try
		{
			HibernateUtil.beginTransaction();
			Users result = convertToDAO(user);
			save(result);
			user.setId(result.getId());
			HibernateUtil.commitTransaction();
		}
		catch (Exception e)
		{
			HibernateUtil.rollbackTransaction();
		}
	}

	@Override
	public void update(User user)
	{
		try
		{
			HibernateUtil.beginTransaction();
			merge(convertToDAO(user));
			HibernateUtil.commitTransaction();
		}
		catch (Exception e)
		{
			HibernateUtil.rollbackTransaction();
		}
	}

	@Override
	public void delete(int id)
	{
		try
		{
			HibernateUtil.beginTransaction();
			delete(convertToDAO(findByID(id)));
			HibernateUtil.commitTransaction();
		}
		catch (Exception e)
		{
			HibernateUtil.rollbackTransaction();
		}

	}
}
