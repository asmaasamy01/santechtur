package com.example.santechtur.service.implement;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.santechtur.dto.UserAccountDto;
import com.example.santechtur.mapper.UserAccountMapper;
import com.example.santechtur.model.UserAccountModel;
import com.example.santechtur.repo.UserAccountRepo;
import com.example.santechtur.service.UserAccountService;

@Service
public class userAccountServiceImplement implements UserAccountService {

	private UserAccountRepo rep;
	private UserAccountMapper userMapper;

	@Override
	public String registerUser(UserAccountDto userDto) {

		Optional<UserAccountModel> user = rep.findByUserName(userDto.getUserName());

		if (!user.isEmpty()) {
			UserAccountModel userModel = new UserAccountModel();
			userModel.setPassword(userDto.getUserName());
			userModel.setPassword(userDto.getPassword());

			rep.save(userModel);
			return "user registered successfully";
		} else {
			return "user already existed";
		}
	}

	@Override
	public Object fetchUser(long id) {

		Optional<UserAccountModel> user = rep.findById(id);

		if (!user.isEmpty()) {
			return userMapper.mapModelToDto(user.get());
		} else {
			return "user not found, register first";
		}

	}

	@Override
	public String userVerification(String email, String code) {
		Optional<UserAccountModel> user = rep.findByEmailAndVerifiedCode(email, code);
		if (!user.isEmpty()) {
			return "user verified";
		} else {
			return "user not verified";
		}
	}

	@Override
	public Object userLogin(String userName, String password) {
		Optional<UserAccountModel> user = rep.findByUserNameAndPassword(userName, password);
		if (!user.isEmpty()) {
			return user.get();
		} else {
			return "Not authorized user , please register first";
		}
	}

}
