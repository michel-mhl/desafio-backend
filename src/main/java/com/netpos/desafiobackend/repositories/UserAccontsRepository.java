package com.netpos.desafiobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netpos.desafiobackend.domain.UserAccounts;

@Repository
public interface UserAccontsRepository extends JpaRepository<UserAccounts,Integer> {

}
