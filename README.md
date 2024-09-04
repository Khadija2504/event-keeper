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

### Fonctionnalités Utilisateur

- **Afficher les événements** : Consulter tous les événements disponibles.
- **S'inscrire à un événement** : S'inscrire à un événement en utilisant les détails du participant.
- **Se désinscrire d'un événement** : Se désinscrire d'un événement.
- **Afficher mes inscriptions** : Voir tous les événements auxquels le participant est actuellement inscrit.
- **Modifier mes détails** : Mettre à jour les informations du participant comme le nom et l'adresse e-mail.

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
