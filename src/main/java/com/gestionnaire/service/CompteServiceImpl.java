package com.gestionnaire.service;

import com.gestionnaire.model.Compte;
import com.gestionnaire.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public List<Compte> findAll() {
        return compteRepository.findAll();
    }

    @Override
    public Optional<Compte> findById(Long id) {
        return compteRepository.findById(id);
    }

    @Override
    public Compte save(Compte compte) {
        // Logique métier peut être ajoutée ici (ex: chiffrement du mot de passe)
        return compteRepository.save(compte);
    }

    @Override
    public void deleteById(Long id) {
        compteRepository.deleteById(id);
    }
}