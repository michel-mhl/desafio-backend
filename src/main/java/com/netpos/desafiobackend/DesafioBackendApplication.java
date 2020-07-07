package com.netpos.desafiobackend;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.netpos.desafiobackend.domain.UserAccounts;
import com.netpos.desafiobackend.repositories.UserAccontsRepository;

@SpringBootApplication
public class DesafioBackendApplication implements CommandLineRunner{
	@Autowired
    private UserAccontsRepository userAccontsRepository;    
    
    public static void main(String[] args) {
        SpringApplication.run(DesafioBackendApplication.class, args);
 
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		UserAccounts usuario1 = new UserAccounts(null,"michel@email","Michel","senha123");
		UserAccounts usuario2 = new UserAccounts(null,"camila@email","Camila","senha123");
		
		userAccontsRepository.saveAll(Arrays.asList(usuario1,usuario2));
	
	}

}
