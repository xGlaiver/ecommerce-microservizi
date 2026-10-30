package com.example.e_commerce.ordine.dto;

import java.math.BigDecimal;

// Copia del JSON restituito dal microservizio prodotti (GET /api/prodotti/{id}).
// Non è una entity: il prodotto non è salvato in questo database.
public record ProdottoDto(
    Long id,
    String nome,
    String descrizione,
    BigDecimal prezzo,
    boolean disponibile
) {}
