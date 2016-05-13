package com.ggmsoft.gradleapi.service;

import java.util.List;

import com.ggmsoft.gradleapi.model.UserModel;

public interface UserService {
	UserModel findBySeq(int seq);
	List<UserModel> findAll();
	UserModel create(UserModel model) throws Exception;
	void delete(int seq) throws Exception;
	UserModel update(UserModel model) throws Exception;
	
}
