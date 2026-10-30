package com.example.e_commerce.ordine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.e_commerce.ordine.entity.OrdineEntity;

public interface OrdineRepository extends JpaRepository<OrdineEntity, Long> {

    List<OrdineEntity> findByUtenteId(Long utenteId);
}
