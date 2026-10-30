package com.example.e_commerce.utente.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_commerce.ordine.dto.OrdineResponseDto;
import com.example.e_commerce.ordine.service.OrdineService;
import com.example.e_commerce.utente.dto.UtenteRequestDto;
import com.example.e_commerce.utente.dto.UtenteResponseDto;
import com.example.e_commerce.utente.service.UtenteService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/utenti")
public class UtenteController {
    
    private final UtenteService utenteService;
    private final OrdineService ordineService;

    public UtenteController(UtenteService utenteService, OrdineService ordineService) {
        this.utenteService = utenteService;
        this.ordineService = ordineService;
    }

    @GetMapping()
    public ResponseEntity<List<UtenteResponseDto>> getUtenti() {
        return ResponseEntity.ok(this.utenteService.getUtenti());
    }

    @PostMapping()
    public ResponseEntity<UtenteResponseDto> createUtente(@RequestBody @Valid UtenteRequestDto utenteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.utenteService.createUtente(utenteRequest));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UtenteResponseDto> getUtenteById(@PathVariable Long id) {
        UtenteResponseDto utente = utenteService.getUtenteById(id);
        
        return ResponseEntity.ok(utente);
    }

    @GetMapping("/{id}/ordini")
    public ResponseEntity<List<OrdineResponseDto>> getOrdiniByUtente(@PathVariable Long id) {
        return ResponseEntity.ok(ordineService.getOrdiniByUtenteId(id));
    }
    
}
