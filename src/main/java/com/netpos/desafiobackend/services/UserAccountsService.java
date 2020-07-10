package com.netpos.desafiobackend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.netpos.desafiobackend.domain.UserAccounts;
import com.netpos.desafiobackend.repositories.UserAccontsRepository;
import com.netpos.desafiobackend.services.exceptions.ObjectNotFoundException;

@Service
public class UserAccountsService {

	@Autowired
	private UserAccontsRepository repo;

	public UserAccounts find(Integer id) {
		Optional<UserAccounts> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + UserAccounts.class.getName()));
	}

	public UserAccounts insert(UserAccounts obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public UserAccounts update(UserAccounts obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id ) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Nao é possivel excluir usuarios que possui produtos");
		}
		
	}
}
