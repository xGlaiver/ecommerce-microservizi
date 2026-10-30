package com.example.e_commerce.utente.mapper;

import com.example.e_commerce.utente.dto.UtenteRequestDto;
import com.example.e_commerce.utente.dto.UtenteResponseDto;
import com.example.e_commerce.utente.entity.UtenteEntity;
import org.springframework.stereotype.Component;

@Component
public class UtenteMapper {

    public UtenteEntity toEntity(UtenteRequestDto utenteRequest) {
        if (utenteRequest == null) {
            return null;
        }

        UtenteEntity utenteEntity = new UtenteEntity();

        utenteEntity.setNome(utenteRequest.nome());
        utenteEntity.setCognome(utenteRequest.cognome());
        utenteEntity.setEmail(utenteRequest.email());

        return utenteEntity;
    }

    public UtenteResponseDto toDto(UtenteEntity utenteEntity) {
        if (utenteEntity == null) {
            return null;
        }

        return new UtenteResponseDto(
                utenteEntity.getId(),
                utenteEntity.getNome(),
                utenteEntity.getCognome(),
                utenteEntity.getEmail()
        );
    }
}
