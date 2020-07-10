package com.netpos.desafiobackend.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netpos.desafiobackend.domain.UserAccounts;
import com.netpos.desafiobackend.services.UserAccountsService;

@RestController
@RequestMapping(value = "/userAcount")
public class UserAccountsResources {
	
	@Autowired
	private UserAccountsService service;
		
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<UserAccounts> find(@PathVariable Integer id) {
		UserAccounts user = service.find(id);
		return ResponseEntity.ok().body(user);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserAccounts obj){
		obj = service.insert(obj);
		URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void>update(@RequestBody UserAccounts obj,@PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
