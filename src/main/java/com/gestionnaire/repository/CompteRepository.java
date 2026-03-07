package com.gestionnaire.repository;

import com.gestionnaire.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    // Méthodes personnalisées peuvent être ajoutées ici si nécessaire
}