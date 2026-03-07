package com.gestionnaire.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "comptes")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le site web est obligatoire")
    @Pattern(regexp = "^https://.*", message = "L'URL du site web doit commencer par https")
    @Column(name = "site_web")
    private String siteWeb;

    @NotBlank(message = "L'identifiant est obligatoire")
    private String identifiant;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "mot_de_passe_chiffre")
    private String motDePasseChiffre;

    @Column(name = "note_privee")
    private String notePrivee;

    public Compte() {}

    public Compte(String siteWeb, String identifiant, String motDePasseChiffre, String notePrivee) {
        this.siteWeb = siteWeb;
        this.identifiant = identifiant;
        this.motDePasseChiffre = motDePasseChiffre;
        this.notePrivee = notePrivee;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSiteWeb() { return siteWeb; }
    public void setSiteWeb(String siteWeb) { this.siteWeb = siteWeb; }

    public String getIdentifiant() { return identifiant; }
    public void setIdentifiant(String identifiant) { this.identifiant = identifiant; }

    public String getMotDePasseChiffre() { return motDePasseChiffre; }
    public void setMotDePasseChiffre(String motDePasseChiffre) { this.motDePasseChiffre = motDePasseChiffre; }

    public String getNotePrivee() { return notePrivee; }
    public void setNotePrivee(String notePrivee) { this.notePrivee = notePrivee; }
}