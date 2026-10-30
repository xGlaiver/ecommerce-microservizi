package com.example.prodotti.prodotto.dto;

import java.math.BigDecimal;

public record ProdottoResponseDto(
    Long id,
    String nome,
    String descrizione,
    BigDecimal prezzo,
    boolean disponibile
) {}
