package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repo;

	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}
	public UserService() {
		
	}
	
	public void save(User user) {
		repo.save(user);
	}
	
	public int checkUser(String email,String password) {
		if(repo.existsByEmail(email)) {
			User user=repo.getUserByEmail(email);
			if(user.getPassword().equals(password))return 0;
			else return 1;
		}
		else return 2;
	}
	public User getUser(String email) {
		return repo.getUserByEmail(email);
	}
}
