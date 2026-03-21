package com.gestionnaire.service;

import com.gestionnaire.exception.ResourceNotFoundException;
import com.gestionnaire.model.Compte;
import com.gestionnaire.repository.CompteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteServiceImpl implements CompteService {

    private final CompteRepository compteRepository;
    private final PasswordEncoder passwordEncoder;

    public CompteServiceImpl(CompteRepository compteRepository, PasswordEncoder passwordEncoder) {
        this.compteRepository = compteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Compte createCompte(Compte compte) {
        compte.setMotDePasseChiffre(passwordEncoder.encode(compte.getMotDePasseChiffre()));
        return compteRepository.save(compte);
    }

    @Override
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    @Override
    public Compte getCompteById(Long id) {
        return compteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Compte non trouve avec id: " + id));
    }

    @Override
    public Compte updateCompte(Long id, Compte compte) {
        Compte existingCompte = getCompteById(id);

        existingCompte.setSiteWeb(compte.getSiteWeb());
        existingCompte.setIdentifiant(compte.getIdentifiant());
        existingCompte.setNotePrivee(compte.getNotePrivee());

        if (compte.getMotDePasseChiffre() != null && !compte.getMotDePasseChiffre().isBlank()) {
            existingCompte.setMotDePasseChiffre(passwordEncoder.encode(compte.getMotDePasseChiffre()));
        }

        return compteRepository.save(existingCompte);
    }

    @Override
    public void deleteCompte(Long id) {
        Compte existingCompte = getCompteById(id);
        compteRepository.delete(existingCompte);
    }
}
