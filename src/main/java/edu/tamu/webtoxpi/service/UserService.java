package edu.tamu.webtoxpi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.tamu.webtoxpi.dao.entity.CUser;
import edu.tamu.webtoxpi.service.manager.fff;

@Service
public class UserService
{
	public List<CUser> findAll()
	{
		fff f = new fff();
		return f.all();
	}
}
