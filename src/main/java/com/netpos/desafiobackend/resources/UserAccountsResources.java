package com.netpos.desafiobackend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netpos.desafiobackend.domain.UserAccounts;
import com.netpos.desafiobackend.services.UserAccountsService;

@RestController
@RequestMapping(value = "/userAcount")
public class UserAccountsResources {
	
	@Autowired
	private UserAccountsService service;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		UserAccounts user = service.buscar(id);
		return ResponseEntity.ok().body(user);
		

	}
}
