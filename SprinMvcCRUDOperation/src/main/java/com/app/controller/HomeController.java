package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;
import com.app.serviceimpl.HomeService;

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	@RequestMapping("/")
	public String landingPage() {
		return "login";
	}

	@RequestMapping("/registrationPage")
	public String registrationPage() {
		return "registration";
	}

	@RequestMapping("/register")
	public String saveUser(@ModelAttribute User user, ModelMap map) {

		System.out.println(user.getName());
		System.out.println(user.getUname());
		System.out.println(user.getPassword());
		int id = homeService.saveUser(user);
		if (id > 0) {
			map.addAttribute("msg", "User added sucessfully....");
			return "login";
		} else {
			return "registration";
		}
	}

	@RequestMapping("/login")
	public String loginCheck(@RequestParam String uname, @RequestParam String password, ModelMap map) {

		System.out.println(uname);
		System.out.println(password);

		int id = homeService.loginCheck(uname, password);
		if (id > 0) {

			List<User> list = homeService.getAllUsers();
			for (User u : list) {
				System.out.println(u.getName());
				System.out.println(u.getUname());
				System.out.println(u.getPassword());
			}
			map.addAttribute("userList", list);
			return "success";
		} else {
			map.addAttribute("msg", "Invalid Cradentials...");
			return "login";
		}

	}

	@RequestMapping("/delete/{uid}")
	public String deleteUser(@PathVariable("uid") int uid, ModelMap map) {

		List<User> userList = homeService.deleteUser(uid);
		map.addAttribute("userList", userList);
		return "success";
	}

	@RequestMapping("/edit/{uid}")
	public String editUser(@PathVariable("uid") int uid, ModelMap map) {

		User user = homeService.editUser(uid);

		map.addAttribute("data", user);
		return "edit";
	}

	@RequestMapping("/update")
	public String updateUser(@ModelAttribute User user, ModelMap map) {

		List<User> userList = homeservice.updateUser(user);
		map.addAttribute("userList", userList);
		return "success";
	}

}
