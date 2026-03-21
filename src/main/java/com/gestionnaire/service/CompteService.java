package com.gestionnaire.service;

import com.gestionnaire.model.Compte;

import java.util.List;

public interface CompteService {
    Compte createCompte(Compte compte);

    List<Compte> getAllComptes();

    Compte getCompteById(Long id);

    Compte updateCompte(Long id, Compte compte);

    void deleteCompte(Long id);
}
