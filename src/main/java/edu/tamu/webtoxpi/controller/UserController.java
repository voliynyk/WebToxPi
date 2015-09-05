package edu.tamu.webtoxpi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.tamu.webtoxpi.dao.entity.CUser;
import edu.tamu.webtoxpi.service.UserService;

@Controller
public class UserController
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView getUsersView() {
		ModelAndView mv = new ModelAndView("usersView");
		mv.addObject("usersModel", userService.findAll());
		return mv;
	}

	@RequestMapping(value = "/usersList", method = RequestMethod.GET)
	public @ResponseBody List<CUser> getUsersRest() {
		return userService.findAll();
	}
}
