package com.example.santechtur.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.santechtur.model.UserAccountModel;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccountModel, Long> {
	
	Optional<UserAccountModel> findByUserName(String userName);
	Optional<UserAccountModel> findByEmailAndVerifiedCode(String email,String code);
	Optional<UserAccountModel> findByUserNameAndPassword(String userName,String password);

}
