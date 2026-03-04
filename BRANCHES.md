# Gestion des Branches Git - Gestionnaire de Mots de Passe

## Responsable Projet : HAITAM EL ASSI

---

## Branches du projet

| Branche | Responsable | Description |
|---------|-------------|-------------|
| `main` | HAITAM EL ASSI | Branche stable, uniquement du code validé |
| `feature-model` | MAJDA ECHABBI | Entité Compte (Model) |
| `feature-database` | AYA CHADLI | Configuration H2, schema.sql, data.sql |
| `feature-repository` | KACHANI WISSAL | CompteRepository (accès données) |
| `feature-service` | ILHAM HOUZAL | CompteService (logique métier) |
| `feature-controller` | (à définir) | CompteController (API REST) |
| `feature-validation` | HIBA HILITY | Validation des entrées (@NotBlank, @Size, @Valid) |
| `feature-security` | EL ADNANI MALAK | Sécurité (BCrypt, @JsonIgnore) |
| `feature-exception` | YASSINE EL KHARAZ | GlobalExceptionHandler + Tests Postman |

---

## Règles obligatoires

1. **Personne ne travaille directement sur `main`**
2. Chaque membre crée sa branche depuis `main` :
   ```bash
   git checkout main
   git pull origin main
   git checkout -b feature-nom
   ```
3. Après développement :
   ```bash
   git add .
   git commit -m "description claire du changement"
   git push origin feature-nom
   ```
4. Créer une **Pull Request** sur GitHub
5. **Seul le responsable (HAITAM)** valide et merge les Pull Requests

---

## Ordre de développement

1. ✅ Responsable configure le projet (pom.xml, application.properties, structure)
2. Model (MAJDA)
3. Database (AYA)
4. Repository (WISSAL)
5. Service (ILHAM)
6. Controller
7. Validation (HIBA)
8. Sécurité (MALAK)
9. Exceptions + Tests (YASSINE)

---

## Package de base

Tous les fichiers Java doivent être dans le package : `com.gestionnaire`

Exemple :
- Model → `com.gestionnaire.model.Compte`
- Repository → `com.gestionnaire.repository.CompteRepository`
- Service → `com.gestionnaire.service.CompteService`
- Controller → `com.gestionnaire.controller.CompteController`
- Config → `com.gestionnaire.config.SecurityConfig`
- Exception → `com.gestionnaire.exception.GlobalExceptionHandler`
