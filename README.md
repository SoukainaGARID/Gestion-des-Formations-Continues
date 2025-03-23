

# Gestion des Formations Continues

## Description

L'application **Gestion des Formations Continues** est conçue pour gérer les formations continues proposées à un public. Elle permet de centraliser l'ajout de formations, l'inscription des participants, ainsi que le filtrage des inscriptions par formation. L'outil facilite ainsi la gestion des inscriptions et offre une interface conviviale pour administrer les données liées aux formations et aux participants.

## Contexte

Dans le cadre de la gestion des formations continues au sein d'une institution ou d'une entreprise, il est nécessaire de disposer d'un système permettant de centraliser les informations sur les formations et leurs participants, ainsi que d'assurer un suivi des inscriptions.

## Objectifs

- **Centralisation des données** : Regrouper toutes les informations relatives aux formations et aux participants dans une base de données centralisée.
- **Facilité de gestion** : Offrir une interface pour l'ajout de formations, l'inscription des participants et le filtrage des inscriptions.
- **Suivi des inscriptions** : Permettre aux administrateurs de filtrer les inscriptions en fonction des formations.
- **Optimisation de la recherche** : Permettre aux utilisateurs de rechercher une formation par son intitulé.

## Fonctionnalités

### 1. **Ajouter une formation**
   - Permet aux administrateurs d'ajouter une nouvelle formation avec les informations suivantes :
     - **Intitulé** : Nom de la formation.
     - **Durée** : Durée en heures ou jours.
     - **Coût** : Coût de la formation.
   
### 2. **Inscrire un participant**
   - Permet aux administrateurs d'inscrire un participant à une formation. Cela crée une liaison entre le participant et la formation dans la table **`InscriptionFormation`**.

### 3. **Filtrer les inscriptions par formation**
   - Permet aux administrateurs de filtrer et d'afficher tous les participants inscrits à une formation spécifique.

### 4. **Rechercher une formation par nom**
   - Permet aux utilisateurs de rechercher une formation en fonction de son intitulé.

## Schéma de la Base de Données

### Structure des tables :

1. **Formation** : Informations sur les formations proposées.
   ```sql
   CREATE TABLE formation (
       id INT(11) AUTO_INCREMENT PRIMARY KEY,
       intitule VARCHAR(255) NOT NULL,
       duree INT NOT NULL,
       cout DECIMAL(10,2) NOT NULL
   );
   ```

2. **Participant** : Informations sur les participants inscrits aux formations.
   ```sql
   CREATE TABLE participant (
       id INT(11) AUTO_INCREMENT PRIMARY KEY,
       nom VARCHAR(100) NOT NULL,
       prenom VARCHAR(100) NOT NULL,
       email VARCHAR(255) NOT NULL UNIQUE
   );
   ```

3. **InscriptionFormation** : Table d'association entre les formations et les participants. 
   Cette table permet de gérer les inscriptions des participants aux formations.
   ```sql
   CREATE TABLE inscriptionformation (
       formation_id INT(11) NOT NULL,
       participant_id INT(11) NOT NULL,
       PRIMARY KEY (formation_id, participant_id),
       FOREIGN KEY (formation_id) REFERENCES formation(id) ON DELETE CASCADE ON UPDATE CASCADE,
       FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE ON UPDATE CASCADE
   );
   ```

## Diagrammes

### 1. **Diagramme de Cas d'Utilisation**
  <img width="436" alt="image" src="https://github.com/user-attachments/assets/7d101516-fb92-4754-86a0-eb117f2c7432" />



### 2. **Diagramme de Classe**
  <img width="199" alt="image" src="https://github.com/user-attachments/assets/2a277796-da90-4152-9963-ba102772fb9a" />

### 3. **Architecture du Système**
  
<img width="544" alt="image" src="https://github.com/user-attachments/assets/ed293889-04c8-4c18-abfd-1ef59b83fdd5" />

## Technologies Utilisées

- **Langage de programmation** : Java
- **Framework d'interface graphique** : Java Swing
- **Base de données** : MySQL
- **Bibliothèque graphique** : JFreeChart
- **Outils de développement** :
    - IDE : NetBeans
    - Gestion de base de données : phpMyAdmin
    - Diagramme : MagicDraw
- **Accès aux données** : JDBC

## Structure de l'Application

L'application permet de gérer les trois principales entités :
1. **Formation** : Contient les informations relatives aux formations proposées.
2. **Participant** : Contient les informations des participants inscrits aux formations.
3. **InscriptionFormation** : Assure la liaison entre les formations et les participants.

## Guide d'Utilisation

### 1. **Ajouter une formation**
   - Naviguez vers la section "Gestion des formations".
   - Remplissez le formulaire avec les informations de la formation (intitulé, durée, coût).
   - Cliquez sur "Ajouter" pour enregistrer la formation.

### 2. **Inscrire un participant**
   - Sélectionnez une formation dans le menu déroulant.
   - Choisissez un participant existant ou ajoutez un nouveau participant.
   - Cliquez sur "S'inscrire" pour ajouter l'inscription.

### 3. **Filtrer les inscriptions par formation**
   - Sélectionnez la formation souhaitée.
   - La liste des participants inscrits à cette formation s'affichera automatiquement.

### 4. **Rechercher une formation par nom**
   - Utilisez la fonction de recherche pour trouver une formation par son intitulé.

## Vidéo de démonstration

https://github.com/user-attachments/assets/2ded0741-44fb-42a9-88c0-90ad5f9b07a0


## Conclusion

L'application **Gestion des Formations Continues** est un outil efficace pour centraliser la gestion des formations et des inscriptions. Elle offre une interface conviviale permettant de gérer facilement les formations, d'inscrire des participants et de suivre les inscriptions. Grâce à l'utilisation de Java Swing pour l'interface et de MySQL pour la gestion des données, l'application est robuste et facile à utiliser.







