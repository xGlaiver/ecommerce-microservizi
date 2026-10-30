package com.example.e_commerce.utente.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.e_commerce.ordine.entity.OrdineEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor 
@Entity
@Table(name = "utente", indexes = {
    @Index(name = "idx_utente_email", columnList = "email")
})
public class UtenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;

    private String cognome;

    private String email;

    @OneToMany(mappedBy = "utente")
    private List<OrdineEntity> ordini = new ArrayList<>();
}
    


