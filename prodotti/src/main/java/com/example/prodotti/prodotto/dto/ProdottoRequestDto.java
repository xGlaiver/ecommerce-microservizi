package com.example.prodotti.prodotto.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;

public record ProdottoRequestDto(

    @NotBlank(message = "Il nome è obbligatorio e non può essere vuoto")
    String nome,

    String descrizione,

    @NotNull(message = "Il prezzo è obbligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "Il prezzo deve essere maggiore di 0")
    BigDecimal prezzo,

    @NotNull(message = "Il campo disponibile è obbligatorio")
    Boolean disponibile
) {}
