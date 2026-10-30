package com.example.e_commerce.utente.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.e_commerce.utente.dto.UtenteRequestDto;
import com.example.e_commerce.utente.dto.UtenteResponseDto;
import com.example.e_commerce.utente.entity.UtenteEntity;
import com.example.e_commerce.utente.mapper.UtenteMapper;
import com.example.e_commerce.utente.repository.UtenteRepository;

@Service 
public class UtenteService {

    private final UtenteRepository utenteRepository;
    private final UtenteMapper utenteMapper;

    public UtenteService(UtenteRepository utenteRepository, UtenteMapper utenteMapper) {
        this.utenteRepository = utenteRepository;
        this.utenteMapper = utenteMapper;
    }

    public List<UtenteResponseDto> getUtenti() {
        return this.utenteRepository.findAll().stream()
            .map(utenteMapper::toDto)
            .toList();
    }

    public UtenteResponseDto createUtente(UtenteRequestDto utenteRequest) {

        UtenteEntity utenteEntity = utenteMapper.toEntity(utenteRequest);

        UtenteEntity newUtenteEntity = this.utenteRepository.save(utenteEntity);

        return utenteMapper.toDto(newUtenteEntity);
    }

    public UtenteResponseDto getUtenteById(Long id) {
       
        UtenteEntity utente = utenteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Utente non trovato con ID: " + id));

    return utenteMapper.toDto(utente);
    }

}
