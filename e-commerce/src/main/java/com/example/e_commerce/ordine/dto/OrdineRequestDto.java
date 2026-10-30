package com.example.e_commerce.ordine.dto;

import jakarta.validation.constraints.*;

public record OrdineRequestDto(

    @NotNull(message = "La quantità è obbligatoria")
    @Min(value = 1, message = "La quantità deve essere almeno 1")
    Integer quantita,

    @NotNull(message = "L'id utente è obbligatorio")
    Long utenteId,

    @NotNull(message = "L'id prodotto è obbligatorio")
    Long prodottoId
) {}
