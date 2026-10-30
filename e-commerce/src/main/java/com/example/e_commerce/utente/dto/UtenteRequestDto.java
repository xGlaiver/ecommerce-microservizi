package com.example.e_commerce.utente.dto;

import jakarta.validation.constraints.*;

public record UtenteRequestDto(

    @NotBlank(message = "Il nome è obbligatorio e non può essere vuoto")
    @Size(min = 2, max = 50, message = "Il nome deve essere compreso tra 2 e 50 caratteri")
    String nome,

    @NotBlank(message = "Il cognome è obbligatorio e non può essere vuoto")
    @Size(min = 2, max = 50, message = "Il cognome deve essere compreso tra 2 e 50 caratteri")
    String cognome,

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "Il formato dell'email non è valido")
    String email
) {}