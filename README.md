# Astronaut Daily Schedule Organizer

## Description
The Astronaut Daily Schedule Organizer is a console-based Java application designed to help astronauts manage their daily tasks efficiently. This project demonstrates the implementation of various design patterns and programming principles, making it an excellent example for educational purposes as well as a practical tool for task management.

## Features
- Add new tasks with description, start time, end time, and priority
- Remove existing tasks
- View all tasks sorted by start time
- Mark tasks as completed
- Prevent scheduling conflicts
- Case-insensitive user input handling
- Robust exception handling

## Design Patterns Used
- Singleton: Ensures a single instance of the ScheduleManager
- Factory: Creates Task objects
- Observer: Notifies of task updates

## SOLID Principles
This project adheres to SOLID principles:
- Single Responsibility Principle
- Open-Closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle

## Project Structure
- `AstronautScheduleOrganizer.java`: Main class to run the application
- `Task.java`: Represents a task with its properties and methods
- `TaskFactory.java`: Factory for creating Task objects
- `ScheduleManager.java`: Manages the collection of tasks (Singleton)
- `ScheduleObserver.java`: Observer interface for notifications
- `ConsoleUI.java`: Handles user interaction through the console
- `ScheduleExceptions.java`: Custom exceptions for the application

## How to Run
1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Compile all Java files:
3. Run the main class:

## Usage
Follow the on-screen prompts to:
1. Add a new task
2. Remove a task
3. View all tasks
4. Mark a task as completed
5. Exit the application

## Contributing
Contributions to improve the Astronaut Daily Schedule Organizer are welcome. Please feel free to fork the repository, make changes, and submit a pull request.

## License
This project is open source and available under the [MIT License](LICENSE).

## Author
Abishek Madhavan

## Acknowledgments
- This project was created as part of Astronaut Work Sheduling java Application
