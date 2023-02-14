package com.example.santechtur.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.santechtur.dto.UserAccountDto;
import com.example.santechtur.service.UserAccountService;

@RestController
@RequestMapping("/santechture")
public class UserController {
	private UserAccountService service;

	@GetMapping("/hi")
	public String loadList() {
		return "hello";
	}

	// registration API
	@PostMapping("/api/user/register")
	public String userRegistration(@RequestBody UserAccountDto userDto) {
		return service.registerUser(userDto);
	}

	// fetch user data API
	@GetMapping("/api/user/fetch/{id}")
	public Object fetchUser(@PathVariable("id") Long id) {
		return service.fetchUser(id);
	}

	// user Verification
	@GetMapping("/api/user/verify/{email}/{code}")
	public String verifyUser(@PathVariable("email") String email, @PathVariable("code") String code) {
		return service.userVerification(email, code);
	}

	// user loggin
	// TODO >>> checnge it to post for securing the login data
	@GetMapping("/api/user/login/{userName}/{password}")
	public Object userLoggin(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		return service.userLogin(userName, password);
	}

}
