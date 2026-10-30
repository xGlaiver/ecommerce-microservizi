package com.example.e_commerce.ordine.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.e_commerce.ordine.enums.StatoOrdine;

public record OrdineResponseDto(
    Long id,
    Integer quantita,
    BigDecimal prezzoTotale,
    LocalDateTime dataOrdine,
    StatoOrdine stato,
    Long utenteId,
    Long prodottoId
) {}