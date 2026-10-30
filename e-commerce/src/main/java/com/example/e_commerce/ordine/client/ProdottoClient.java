package com.example.e_commerce.ordine.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.example.e_commerce.ordine.dto.ProdottoDto;

@Component
public class ProdottoClient {

    private final RestClient restClient;

    public ProdottoClient(@Value("${prodotti.service.url}") String prodottiServiceUrl) {
        this.restClient = RestClient.create(prodottiServiceUrl);
    }

    public ProdottoDto getProdottoById(Long id) {
        return restClient.get()
                .uri("/api/prodotti/{id}", id)
                .retrieve()
                .onStatus(status -> status == HttpStatus.NOT_FOUND, (request, response) -> {
                    throw new RuntimeException("Prodotto non trovato con ID: " + id);
                })
                .body(ProdottoDto.class);
    }
}
