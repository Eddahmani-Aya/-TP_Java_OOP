CREATE DATABASE SCOLARITE;

USE SCOLARITE;

CREATE TABLE ETUDIANTS(
    Id_Etud INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(25) NOT NULL,
    Prenom VARCHAR(25) NOT NULL,
    Email VARCHAR(80),
    Ville VARCHAR(25)
);

INSERT INTO ETUDIANTS(Nom, Prenom, Email, Ville) VALUES
('Karimi', 'Sara', 'sara.k@gmail.com', 'Rabat'),
('Hassan', 'Youssef', 'youssef.h@gmail.com', 'Casablanca'),
('Naji', 'Aya', 'aya.n@gmail.com', 'Marrakech'),
('El Idrissi', 'Omar', 'omar.id@gmail.com', 'Fes'),
('Benali', 'Imane', 'imane.b@gmail.com', 'Agadir');