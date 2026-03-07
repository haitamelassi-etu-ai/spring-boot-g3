package com.gestionnaire.service;

import com.gestionnaire.model.Compte;
import com.gestionnaire.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    private CompteRepository compteRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
        // Chiffrement du mot de passe
        String motDePasseChiffre = passwordEncoder.encode(compte.getMotDePasseChiffre());
        compte.setMotDePasseChiffre(motDePasseChiffre);
        return compteRepository.save(compte);
    }

    @Override
    public void deleteById(Long id) {
        compteRepository.deleteById(id);
    }
}