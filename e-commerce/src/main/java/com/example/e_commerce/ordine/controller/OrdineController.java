package com.example.e_commerce.ordine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_commerce.ordine.dto.OrdineRequestDto;
import com.example.e_commerce.ordine.dto.OrdineResponseDto;
import com.example.e_commerce.ordine.service.OrdineService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/ordini")
public class OrdineController {

    private final OrdineService ordineService;

    public OrdineController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @PostMapping()
    public ResponseEntity<OrdineResponseDto> createOrdine(@RequestBody @Valid OrdineRequestDto ordineRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.ordineService.createOrdine(ordineRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdineResponseDto> getOrdineById(@PathVariable Long id) {
        OrdineResponseDto ordine = ordineService.getOrdineById(id);

        return ResponseEntity.ok(ordine);
    }

}
