package com.netpos.desafiobackend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netpos.desafiobackend.domain.UserAccounts;
import com.netpos.desafiobackend.repositories.UserAccontsRepository;

@Service
public class UserAccountsService {
	
@Autowired
	private UserAccontsRepository repo;

	public UserAccounts buscar(Integer id) {
		Optional<UserAccounts> user = repo.findById(id);
		return user.orElse(null);
	}

}
