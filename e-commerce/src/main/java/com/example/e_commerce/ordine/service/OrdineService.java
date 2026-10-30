package com.example.e_commerce.ordine.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.e_commerce.ordine.client.ProdottoClient;
import com.example.e_commerce.ordine.dto.OrdineRequestDto;
import com.example.e_commerce.ordine.dto.OrdineResponseDto;
import com.example.e_commerce.ordine.dto.ProdottoDto;
import com.example.e_commerce.ordine.entity.OrdineEntity;
import com.example.e_commerce.ordine.enums.StatoOrdine;
import com.example.e_commerce.ordine.mapper.OrdineMapper;
import com.example.e_commerce.ordine.repository.OrdineRepository;
import com.example.e_commerce.utente.entity.UtenteEntity;
import com.example.e_commerce.utente.repository.UtenteRepository;

@Service
public class OrdineService {

    private final OrdineRepository ordineRepository;
    private final UtenteRepository utenteRepository;
    private final ProdottoClient prodottoClient;
    private final OrdineMapper ordineMapper;

    public OrdineService(OrdineRepository ordineRepository, UtenteRepository utenteRepository, ProdottoClient prodottoClient, OrdineMapper ordineMapper) {
        this.ordineRepository = ordineRepository;
        this.utenteRepository = utenteRepository;
        this.prodottoClient = prodottoClient;
        this.ordineMapper = ordineMapper;
    }

    public OrdineResponseDto createOrdine(OrdineRequestDto ordineRequest) {

        // Utente: stesso progetto, si recupera dal database con JPA
        UtenteEntity utente = utenteRepository.findById(ordineRequest.utenteId())
            .orElseThrow(() -> new RuntimeException("Utente non trovato con ID: " + ordineRequest.utenteId()));

        // Prodotto: altro progetto, si recupera con una chiamata HTTP al microservizio prodotti
        ProdottoDto prodotto = prodottoClient.getProdottoById(ordineRequest.prodottoId());

        if (!prodotto.disponibile()) {
            throw new RuntimeException("Prodotto non disponibile: " + prodotto.nome());
        }

        BigDecimal prezzoTotale = prodotto.prezzo().multiply(BigDecimal.valueOf(ordineRequest.quantita()));

        OrdineEntity ordineEntity = ordineMapper.toEntity(ordineRequest, utente, prezzoTotale, StatoOrdine.CREATO);

        OrdineEntity newOrdineEntity = this.ordineRepository.save(ordineEntity);

        return ordineMapper.toDto(newOrdineEntity);
    }

    public OrdineResponseDto getOrdineById(Long id) {

        OrdineEntity ordine = ordineRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ordine non trovato con ID: " + id));

        return ordineMapper.toDto(ordine);
    }

    public List<OrdineResponseDto> getOrdiniByUtenteId(Long utenteId) {

        if (!utenteRepository.existsById(utenteId)) {
            throw new RuntimeException("Utente non trovato con ID: " + utenteId);
        }

        return ordineRepository.findByUtenteId(utenteId).stream()
            .map(ordineMapper::toDto)
            .toList();
    }
}
