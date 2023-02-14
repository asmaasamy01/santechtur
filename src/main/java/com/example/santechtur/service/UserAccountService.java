package com.example.santechtur.service;

import com.example.santechtur.dto.UserAccountDto;

public interface UserAccountService {

	public String registerUser(UserAccountDto userDto);

	public Object fetchUser(long id);

	public String userVerification(String email,String code);
	
	public Object userLogin(String userName,String password);

}
