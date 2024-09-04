# Event Management System

## Overview

The **Event Management System** is a console-based Java application designed to manage events such as conferences, seminars, meetings, and workshops. The system allows administrators to manage events and participants, while regular users (participants) can view and register for events. The application features a role-based system that allows seamless switching between administrator and participant roles without needing to restart the application.

## Features

### Administrator

- **Add Event**: Create new events with details such as name, location, date, and type.
- **Update Event**: Modify details of existing events.
- **Delete Event**: Remove events from the system.
- **View All Events**: List all events in the system.
- **Manage Participants**:
  - Add Participant: Register new participants.
  - Update Participant: Modify participant details.
  - Delete Participant: Remove participants from the system.
  - View All Participants: List all registered participants.

### Participant

- **View Events**: List all available events.
- **Register for Event**: Sign up for an event by providing participant details.
- **Unregister from Event**: Withdraw from an event.
- **View My Registrations**: See all events the participant is registered for.
- **Edit My Details**: Update participant name and email.

### General

- **Role Switching**: Seamlessly switch between administrator and participant roles without exiting the application.

## Project Structure

The project follows a typical Java project structure:

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

