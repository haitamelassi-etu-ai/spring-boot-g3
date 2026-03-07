package com.gestionnaire.service;

import com.gestionnaire.model.Compte;
import java.util.List;
import java.util.Optional;

public interface CompteService {
    List<Compte> findAll();
    Optional<Compte> findById(Long id);
    Compte save(Compte compte);
    void deleteById(Long id);
    // Méthodes métier supplémentaires peuvent être ajoutées ici
}