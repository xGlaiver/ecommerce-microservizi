package com.example.e_commerce.utente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.e_commerce.utente.entity.UtenteEntity;

public interface UtenteRepository extends JpaRepository<UtenteEntity, Long> {
    
}
