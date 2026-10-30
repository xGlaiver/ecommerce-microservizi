package com.example.prodotti.prodotto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prodotti.prodotto.entity.ProdottoEntity;

public interface ProdottoRepository extends JpaRepository<ProdottoEntity, Long> {

}
