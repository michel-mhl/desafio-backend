package com.netpos.desafiobackend;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.netpos.desafiobackend.domain.Produto;
import com.netpos.desafiobackend.domain.UserAccounts;
import com.netpos.desafiobackend.repositories.ProdutoRepository;
import com.netpos.desafiobackend.repositories.UserAccontsRepository;

@SpringBootApplication
public class DesafioBackendApplication implements CommandLineRunner{
	@Autowired
    private UserAccontsRepository userAccontsRepository;    
	
	@Autowired
    private ProdutoRepository produtoRepository;   
    
    public static void main(String[] args) {
        SpringApplication.run(DesafioBackendApplication.class, args);
 
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		UserAccounts usuario1 = new UserAccounts(null,"michel@email","Michel","senha123");
		UserAccounts usuario2 = new UserAccounts(null,"camila@email","Camila","senha123"); 
		
		Produto produto1 = new Produto(null,"Computador",1200.00,30);
		Produto produto2 = new Produto(null,"Geladeira",900.00,50);
		Produto produto3 = new Produto(null,"Fogão",4000.00,70);
		Produto produto4 = new Produto(null,"TV",2200.00,200);
		
		usuario1.getProdutos().addAll(Arrays.asList(produto1,produto2,produto3));
		usuario2.getProdutos().addAll(Arrays.asList(produto4,produto3));
		
		produto1.getUsuarios().addAll(Arrays.asList(usuario1));
		produto2.getUsuarios().addAll(Arrays.asList(usuario1));
		produto3.getUsuarios().addAll(Arrays.asList(usuario1,usuario2));
		produto4.getUsuarios().addAll(Arrays.asList(usuario2));
		
		userAccontsRepository.saveAll(Arrays.asList(usuario1,usuario2));
		produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3,produto4));
	
	}

}
