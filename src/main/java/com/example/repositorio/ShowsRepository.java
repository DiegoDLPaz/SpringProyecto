package com.example.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelo.Shows;

public interface ShowsRepository extends JpaRepository<Shows,String> {
	
	List<Shows> findBytipoStartingWith(String tipo);

}
