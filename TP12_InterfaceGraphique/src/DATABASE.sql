-- 1) Creation base
CREATE DATABASE  gestionetudiants
-- 2) Creation table
DROP TABLE IF EXISTS etudiant;
CREATE TABLE etudiant (
	 id SERIAL PRIMARY KEY,
	 prenom VARCHAR(50) NOT NULL,
	 nom VARCHAR(50) NOT NULL,
	 email VARCHAR(120) NOT NULL UNIQUE,
	 dateinscription DATE NOT NULL
);
-- 3) Insertions de test
INSERT INTO etudiant(prenom, nom, email, dateinscription) VALUES
	('Sara', 'El Amrani', 'sara.elamrani@example.com', '2025-09-10'),
	('Youssef','Bennani', 'youssef.bennani@example.com', '2025-10-03'),
	('Hajar', 'Ait Ali', 'hajar.aitali@example.com', '2025-10-20'),
	('Omar', 'Chraibi', 'omar.chraibi@example.com', '2025-11-02');
-- 4) Verification
SELECT * FROM etudiant;