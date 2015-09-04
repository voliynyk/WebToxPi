package edu.tamu.webtoxpi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.tamu.webtoxpi.entity.User;

@Service
public class UserService {

	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		users.add(new User(1l, "user1", "gfdgdf", "sd@dsds.ds"));
		users.add(new User(2l, "user2", "gfdgdf", "sd@dsds.ds"));
		users.add(new User(3l, "user3", "gfdgdf", "sd@dsds.ds"));
		users.add(new User(4l, "user4", "gfdgdf", "sd@dsds.ds"));
		return users;
	}

}
