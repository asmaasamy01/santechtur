package com.example.santechtur.mapper;

import org.springframework.stereotype.Component;

import com.example.santechtur.dto.UserAccountDto;
import com.example.santechtur.model.UserAccountModel;

@Component
public class UserAccountMapper {

	public UserAccountDto mapModelToDto(UserAccountModel model) {

		UserAccountDto dto = new UserAccountDto();

		dto.setId(model.getId());
		dto.setUserName(model.getUserName());
		dto.setPassword(model.getPassword());
		dto.setEmail(model.getEmail());

		return dto;

	}
}
