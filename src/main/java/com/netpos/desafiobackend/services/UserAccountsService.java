package com.netpos.desafiobackend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netpos.desafiobackend.domain.UserAccounts;
import com.netpos.desafiobackend.repositories.UserAccontsRepository;
import com.netpos.desafiobackend.services.exceptions.*;

@Service
public class UserAccountsService {

	@Autowired
	private UserAccontsRepository repo;

	public UserAccounts buscar(Integer id) {
		Optional<UserAccounts> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + UserAccounts.class.getName()));
	}

}
