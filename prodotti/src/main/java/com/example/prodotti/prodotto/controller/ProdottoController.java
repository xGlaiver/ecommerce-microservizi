package com.example.prodotti.prodotto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prodotti.prodotto.dto.ProdottoRequestDto;
import com.example.prodotti.prodotto.dto.ProdottoResponseDto;
import com.example.prodotti.prodotto.service.ProdottoService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/prodotti")
public class ProdottoController {

    private final ProdottoService prodottoService;

    public ProdottoController(ProdottoService prodottoService) {
        this.prodottoService = prodottoService;
    }

    @GetMapping()
    public ResponseEntity<List<ProdottoResponseDto>> getProdotti() {
        return ResponseEntity.ok(this.prodottoService.getProdotti());
    }

    @PostMapping()
    public ResponseEntity<ProdottoResponseDto> createProdotto(@RequestBody @Valid ProdottoRequestDto prodottoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.prodottoService.createProdotto(prodottoRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdottoResponseDto> getProdottoById(@PathVariable Long id) {
        return ResponseEntity.ok(prodottoService.getProdottoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdottoResponseDto> updateProdotto(@PathVariable Long id, @RequestBody @Valid ProdottoRequestDto prodottoRequest) {
        return ResponseEntity.ok(prodottoService.updateProdotto(id, prodottoRequest));
    }

}
