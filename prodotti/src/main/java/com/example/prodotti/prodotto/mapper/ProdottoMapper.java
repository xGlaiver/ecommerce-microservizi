package com.example.prodotti.prodotto.mapper;

import com.example.prodotti.prodotto.dto.ProdottoRequestDto;
import com.example.prodotti.prodotto.dto.ProdottoResponseDto;
import com.example.prodotti.prodotto.entity.ProdottoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdottoMapper {

    public ProdottoEntity toEntity(ProdottoRequestDto prodottoRequest) {
        if (prodottoRequest == null) {
            return null;
        }

        ProdottoEntity prodottoEntity = new ProdottoEntity();
        updateEntity(prodottoEntity, prodottoRequest);

        return prodottoEntity;
    }

    // Usato dalla PUT: sovrascrive i campi di una entity già esistente (stesso id) invece di crearne una nuova
    public void updateEntity(ProdottoEntity prodottoEntity, ProdottoRequestDto prodottoRequest) {
        prodottoEntity.setNome(prodottoRequest.nome());
        prodottoEntity.setDescrizione(prodottoRequest.descrizione());
        prodottoEntity.setPrezzo(prodottoRequest.prezzo());
        prodottoEntity.setDisponibile(prodottoRequest.disponibile());
    }

    public ProdottoResponseDto toDto(ProdottoEntity prodottoEntity) {
        if (prodottoEntity == null) {
            return null;
        }

        return new ProdottoResponseDto(
                prodottoEntity.getId(),
                prodottoEntity.getNome(),
                prodottoEntity.getDescrizione(),
                prodottoEntity.getPrezzo(),
                prodottoEntity.isDisponibile()
        );
    }
}
