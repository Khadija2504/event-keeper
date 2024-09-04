# Système de Gestion d'Événements

## Vue d'ensemble

Le **Système de Gestion d'Événements** est une application Java basée sur la console qui aide à gérer des événements tels que des conférences, des séminaires, des réunions et des ateliers. Le système est conçu pour les administrateurs, qui gèrent les événements et les participants, ainsi que pour les utilisateurs réguliers (participants), qui peuvent consulter et s'inscrire à des événements. L'application permet de basculer facilement entre les rôles d'administrateur et de participant sans avoir à redémarrer l'application.

## Fonctionnalités

### Fonctionnalités Administrateur

- **Ajouter un événement** : Créer de nouveaux événements en spécifiant des détails tels que le nom, le lieu, la date et le type.
- **Modifier un événement** : Modifier les détails des événements existants.
- **Supprimer un événement** : Supprimer des événements du système.
- **Afficher tous les événements** : Lister tous les événements actuellement dans le système.
- **Gérer les participants** :
  - Ajouter un participant : Inscrire de nouveaux participants.
  - Modifier un participant : Modifier les détails des participants.
  - Supprimer un participant : Supprimer des participants du système.
  - Afficher tous les participants : Lister tous les participants inscrits.
  - désinscrire le participant d'un événement : désinscrire le participant d'un événement.
- **Voir toutes les inscriptions aux événements** : Afficher une liste complète des inscriptions pour tous les événements.
- **Rechercher des événements** : Rechercher des événements spécifiques en fonction de critères tels que la date, le lieu ou le type.
- **Événements avec au moins un participant** : Afficher tous les événements ayant au moins un participant inscrit.
- **Générer des rapports** :
  - **Rapport pour la semaine prochaine** : Générer un rapport des événements à venir la semaine prochaine avec leurs inscriptions.
  - **Rapport pour la semaine précédente** : Générer un rapport des événements qui ont eu lieu la semaine dernière avec leurs inscriptions.
  - 
### Fonctionnalités Utilisateur Réguliers

- **Afficher les événements** : Consulter tous les événements disponibles.
- **S'inscrire à un événement** : S'inscrire à un événement en utilisant les détails du participant.
- **Se désinscrire d'un événement** : Se désinscrire d'un événement.
- **Afficher mes inscriptions** : Voir tous les événements auxquels le participant est actuellement inscrit.
- **Modifier mes détails** : Mettre à jour les informations du participant comme le nom et l'adresse e-mail.
- **Rechercher des événements**: Recherch par date, lieu et type.

### Fonctionnalités Générales

- **Changement de rôle** : Basculez facilement entre les rôles d'administrateur et de participant sans quitter l'application.

## Structure du Projet

Le projet suit une structure Java typique :

```text
EventManagementSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── eventsystem/
│   │   │   │   │   ├── Main.java
│   │   │   │   │   ├── model/
│   │   │   │   │   │   ├── Event.java
│   │   │   │   │   │   ├── Participant.java
│   │   │   │   │   ├── service/
│   │   │   │   │   │   ├── EventService.java
│   │   │   │   │   │   ├── ParticipantService.java
│   │   │   │   │   │   ├── RegistrationService.java
│   │   │   │   │   ├── ui/
│   │   │   │   │   │   ├── ConsoleUI.java
│   │   │   │   │   │   ├── Menu.java
│   │   │   │   │   ├── util/
│   │   │   │   │   │   ├── InputValidator.java
│   │   │   │   │   │   ├── ExceptionHandler.java
```
## Démarrer l'Application
### Cloner le Répertoire :

```sh
git clone https://github.com/yourusername/EventManagementSystem.git
```
### Naviguer dans le Répertoire du Projet :
```sh
cd EventManagementSystem
```
### Compiler le Projet :
```sh
javac -d out -sourcepath src src/com/eventsystem/Main.java
```
### Exécuter l'Application :
```sh
java -cp out com.eventsystem.Main
```
## Interagir avec l'Application

Suivez les instructions à l'écran pour utiliser le système en tant qu'administrateur ou participant.

## Changement de Rôles

Depuis le menu principal, sélectionnez l'option pour changer de rôle. Cela vous permet d'accéder au menu administrateur ou participant sans redémarrer l'application.

## Gestion des Participants

Les participants doivent s'inscrire avec leur nom et leur adresse e-mail. Ils peuvent ensuite modifier leurs détails ou se supprimer du système.

## Explication du Code

- **Main.java** : Le point d'entrée de l'application.
- **Event.java** : Classe modèle représentant un événement avec des propriétés comme le nom, le lieu, la date et le type.
- **Participant.java** : Classe modèle représentant un participant avec des propriétés comme le nom et l'e-mail.
- **EventService.java** : Gère les opérations CRUD liées aux événements.
- **ParticipantService.java** : Gère les opérations liées aux participants.
- **RegistrationService.java** : Gère l'inscription et la désinscription des participants aux événements.
- **ConsoleUI.java** : Fournit une interface utilisateur basée sur la console pour interagir avec l'application.
- **Menu.java** : Contient la logique du menu pour les administrateurs et les participants.
- **SecondMenu.java** : Contient la logique du menu secondaire pour les administrateurs et les participants.
- **InputValidator.java** : Une classe utilitaire pour valider les entrées utilisateur.
- **ExceptionHandler.java** : Une classe utilitaire pour gérer les exceptions de manière appropriée.


### Remarques :

- Les commandes et blocs de code sont formatés pour être affichés correctement sur GitHub.
- Les sections sont organisées de manière logique pour faciliter la lecture et la navigation.
- La traduction a été faite pour conserver la clarté et la précision de la documentation originale.


