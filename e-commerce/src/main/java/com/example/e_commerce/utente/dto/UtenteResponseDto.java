package com.example.e_commerce.utente.dto;

// Niente lista ordini: si leggono da GET /api/utenti/{id}/ordini
public record UtenteResponseDto(
    Long id,
    String nome,
    String cognome,
    String email
) {}
