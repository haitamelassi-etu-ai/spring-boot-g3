CREATE TABLE compte (
    id INT AUTO_INCREMENT PRIMARY KEY,
    site_web VARCHAR(250) NOT NULL,
    identifiant VARCHAR(250) NOT NULL,
    mot_de_passe_chiffre VARCHAR(250) NOT NULL,
    note_privee VARCHAR(400)
);