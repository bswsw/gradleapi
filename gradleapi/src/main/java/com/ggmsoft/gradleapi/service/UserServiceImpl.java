package com.ggmsoft.gradleapi.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggmsoft.gradleapi.model.UserModel;
import com.ggmsoft.gradleapi.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	public UserModel findBySeq(int seq) {
		return userRepository.findOne(seq);
	}

	@Override
	public List<UserModel> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserModel create(UserModel model) throws Exception {
		if (userRepository.findById(model.getId()) != null)
			throw new Exception();
			
		return userRepository.save(model);
	}

	@Override
	public void delete(int seq) throws Exception {
		if (userRepository.exists(seq))
			throw new Exception();
		
		userRepository.delete(seq);
	}

	@Override
	public UserModel update(UserModel model) throws Exception {
		UserModel updateModel = userRepository.findOne(model.getSeq());
		
		if (updateModel == null)
			throw new Exception();
		
		updateModel.setId(model.getId());
		updateModel.setName(model.getName());
		updateModel.setAddressDefault(model.getAddressDefault());
		updateModel.setAddressDetail(model.getAddressDetail());
		
		return updateModel;
	}
	
	

}
