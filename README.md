<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Management System - README</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h1, h2, h3 {
            color: #333;
        }
        h1 {
            text-align: center;
            margin-bottom: 40px;
        }
        code, pre {
            background-color: #eee;
            padding: 5px;
            border-radius: 4px;
        }
        pre {
            overflow-x: auto;
            padding: 10px;
        }
        .container {
            max-width: 800px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        ul {
            list-style: disc inside;
        }
        ol {
            list-style: decimal inside;
        }
        .code-section {
            background-color: #f9f9f9;
            border-left: 5px solid #ccc;
            margin: 20px 0;
            padding: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Event Management System</h1>

    <h2>Overview</h2>
    <p>The <strong>Event Management System</strong> is a console-based Java application designed to manage events such as conferences, seminars, meetings, and workshops. The system allows administrators to manage events and participants, while regular users (participants) can view and register for events. The application features a role-based system that allows seamless switching between administrator and participant roles without needing to restart the application.</p>

    <h2>Features</h2>
    <h3>Administrator</h3>
    <ul>
        <li><strong>Add Event</strong>: Create new events with details such as name, location, date, and type.</li>
        <li><strong>Update Event</strong>: Modify details of existing events.</li>
        <li><strong>Delete Event</strong>: Remove events from the system.</li>
        <li><strong>View All Events</strong>: List all events in the system.</li>
        <li><strong>Manage Participants</strong>:
            <ul>
                <li>Add Participant: Register new participants.</li>
                <li>Update Participant: Modify participant details.</li>
                <li>Delete Participant: Remove participants from the system.</li>
                <li>View All Participants: List all registered participants.</li>
            </ul>
        </li>
    </ul>

    <h3>Participant</h3>
    <ul>
        <li><strong>View Events</strong>: List all available events.</li>
        <li><strong>Register for Event</strong>: Sign up for an event by providing participant details.</li>
        <li><strong>Unregister from Event</strong>: Withdraw from an event.</li>
        <li><strong>View My Registrations</strong>: See all events the participant is registered for.</li>
        <li><strong>Edit My Details</strong>: Update participant name and email.</li>
    </ul>

    <h3>General</h3>
    <ul>
        <li><strong>Role Switching</strong>: Seamlessly switch between administrator and participant roles without exiting the application.</li>
    </ul>

    <h2>Project Structure</h2>
    <p>The project follows a typical Java project structure:</p>
    <pre><code>EventManagementSystem/
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
    </code></pre>

    <h2>Getting Started</h2>

    <h3>Prerequisites</h3>
    <ul>
        <li><strong>Java 8 or higher</strong>: Ensure you have Java Development Kit (JDK) installed on your system.</li>
        <li><strong>IDE (optional)</strong>: You can use an Integrated Development Environment like IntelliJ IDEA or Eclipse for easier project management.</li>
    </ul>

    <h3>Running the Application</h3>
    <ol>
        <li><strong>Clone the Repository</strong>: 
            <pre><code>git clone https://github.com/yourusername/EventManagementSystem.git</code></pre>
        </li>
        <li><strong>Navigate to the Project Directory</strong>:
            <pre><code>cd EventManagementSystem</code></pre>
        </li>
        <li><strong>Compile the Project</strong>:
            <pre><code>javac -d out -sourcepath src src/com/eventsystem/Main.java</code></pre>
        </li>
        <li><strong>Run the Application</strong>:
            <pre><code>java -cp out com.eventsystem.Main</code></pre>
        </li>
        <li><strong>Interact with the Application</strong>:
            <p>Follow the on-screen instructions to use the system as an administrator or participant.</p>
        </li>
    </ol>

    <h3>Switching Roles</h3>
    <p>You can switch between the administrator and participant roles directly from the main menu:</p>
    <ol>
        <li>Select the option to switch roles.</li>
        <li>Access the respective menu based on the selected role.</li>
    </ol>

    <h3>Participant Registration and Management</h3>
    <p>Participants must register with their name and email address. They can edit their details or remove themselves from the system as needed.</p>

    <h2>Code Explanation</h2>
    <ul>
        <li><strong>Main.java</strong>: Entry point of the application.</li>
        <li><strong>Event.java</strong>: Model class representing an event with properties such as name, location, date, and type.</li>
        <li><strong>Participant.java</strong>: Model class representing a participant with properties such as name and email.</li>
        <li><strong>EventService.java</strong>: Handles CRUD operations related to events.</li>
        <li><strong>ParticipantService.java</strong>: Manages participant-related operations.</li>
        <li><strong>RegistrationService.java</strong>: Manages event registration and unregistration for participants.</li>
        <li><strong>ConsoleUI.java</strong>: Provides a console-based user interface, allowing users to interact with the application.</li>
        <li><strong>Menu.java</strong>: Contains the menu logic for both administrators and participants.</li>
        <li><strong>InputValidator.java</strong>: Utility class for validating user input.</li>
        <li><strong>ExceptionHandler.java</strong>: Utility class for handling exceptions gracefully.</li>
    </ul>

    <h2>Future Enhancements</h2>
    <ul>
        <li><strong>Database Integration</strong>: Store events and participants in a database for persistence.</li>
        <li><strong>GUI Interface</strong>: Develop a graphical user interface for a better user experience.</li>
        <li><strong>Advanced Search</strong>: Implement advanced search functionality for events and participants.</li>
    </ul>

    <h2>License</h2>
    <p>This project is licensed under the MIT License. See the <a href="#">LICENSE</a> file for details.</p>

    <h2>Contributing</h2>
    <p>Contributions are welcome! Please fork this repository and submit a pull request for any enhancements or bug fixes.</p>
</div>

</body>
</html>
