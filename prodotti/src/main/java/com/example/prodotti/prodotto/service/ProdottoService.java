package com.example.prodotti.prodotto.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.prodotti.prodotto.dto.ProdottoRequestDto;
import com.example.prodotti.prodotto.dto.ProdottoResponseDto;
import com.example.prodotti.prodotto.entity.ProdottoEntity;
import com.example.prodotti.prodotto.mapper.ProdottoMapper;
import com.example.prodotti.prodotto.repository.ProdottoRepository;

@Service
public class ProdottoService {

    private final ProdottoRepository prodottoRepository;
    private final ProdottoMapper prodottoMapper;

    public ProdottoService(ProdottoRepository prodottoRepository, ProdottoMapper prodottoMapper) {
        this.prodottoRepository = prodottoRepository;
        this.prodottoMapper = prodottoMapper;
    }

    public List<ProdottoResponseDto> getProdotti() {
        return this.prodottoRepository.findAll().stream()
            .map(prodottoMapper::toDto)
            .toList();
    }

    public ProdottoResponseDto createProdotto(ProdottoRequestDto prodottoRequest) {

        ProdottoEntity prodottoEntity = prodottoMapper.toEntity(prodottoRequest);

        ProdottoEntity newProdottoEntity = this.prodottoRepository.save(prodottoEntity);

        return prodottoMapper.toDto(newProdottoEntity);
    }

    public ProdottoResponseDto getProdottoById(Long id) {
        return prodottoMapper.toDto(findProdotto(id));
    }

    public ProdottoResponseDto updateProdotto(Long id, ProdottoRequestDto prodottoRequest) {

        ProdottoEntity prodottoEntity = findProdotto(id);

        prodottoMapper.updateEntity(prodottoEntity, prodottoRequest);

        return prodottoMapper.toDto(this.prodottoRepository.save(prodottoEntity));
    }

    // 404 invece di 500: chi chiama questo servizio (e-commerce) deve poter capire che il prodotto non esiste
    private ProdottoEntity findProdotto(Long id) {
        return prodottoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prodotto non trovato con ID: " + id));
    }
}
