package com.example.e_commerce.ordine.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.example.e_commerce.ordine.enums.StatoOrdine;
import com.example.e_commerce.utente.entity.UtenteEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ordine")
@Getter
@Setter
public class OrdineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantita;

    private BigDecimal prezzoTotale;

    @CreationTimestamp
    private LocalDateTime dataOrdine;

    @Enumerated(EnumType.STRING)
    private StatoOrdine stato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utente_id", nullable = false)
    private UtenteEntity utente;

    private Long prodottoId;
}
    
