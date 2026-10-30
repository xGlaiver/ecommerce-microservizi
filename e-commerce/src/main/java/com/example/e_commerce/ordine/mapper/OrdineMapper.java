package com.example.e_commerce.ordine.mapper;

import com.example.e_commerce.ordine.dto.OrdineRequestDto;
import com.example.e_commerce.ordine.dto.OrdineResponseDto;
import com.example.e_commerce.ordine.entity.OrdineEntity;
import com.example.e_commerce.ordine.enums.StatoOrdine;
import com.example.e_commerce.utente.entity.UtenteEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrdineMapper {

    // Il mapper assembla l'entity completa, ma non calcola nulla:
    // utente, prezzoTotale e stato li ricava il Service e li passa già pronti.
    public OrdineEntity toEntity(OrdineRequestDto ordineRequest, UtenteEntity utente, BigDecimal prezzoTotale, StatoOrdine stato) {
        if (ordineRequest == null) {
            return null;
        }

        OrdineEntity ordineEntity = new OrdineEntity();

        ordineEntity.setQuantita(ordineRequest.quantita());
        ordineEntity.setProdottoId(ordineRequest.prodottoId());
        ordineEntity.setUtente(utente);
        ordineEntity.setPrezzoTotale(prezzoTotale);
        ordineEntity.setStato(stato);

        return ordineEntity;
    }

    public OrdineResponseDto toDto(OrdineEntity ordineEntity) {
        if (ordineEntity == null) {
            return null;
        }

        return new OrdineResponseDto(
                ordineEntity.getId(),
                ordineEntity.getQuantita(),
                ordineEntity.getPrezzoTotale(),
                ordineEntity.getDataOrdine(),
                ordineEntity.getStato(),
                ordineEntity.getUtente() != null ? ordineEntity.getUtente().getId() : null,
                ordineEntity.getProdottoId()
        );
    }
}
