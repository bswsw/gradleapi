package com.ggmsoft.gradleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggmsoft.gradleapi.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

	UserModel findById(String id);
}
