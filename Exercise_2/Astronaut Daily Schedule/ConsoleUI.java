import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements ScheduleObserver {
    private ScheduleManager scheduleManager;
    private Scanner scanner;

    public ConsoleUI() {
        scheduleManager = ScheduleManager.getInstance();
        scheduleManager.addObserver(this);
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim().toLowerCase();

            try {
                switch (choice) {
                    case "1":
                    case "add":
                        addTask();
                        break;
                    case "2":
                    case "remove":
                        removeTask();
                        break;
                    case "3":
                    case "view":
                        viewTasks();
                        break;
                    case "4":
                    case "complete":
                        markTaskAsCompleted();
                        break;
                    case "5":
                    case "exit":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private void addTask() throws ScheduleExceptions.TaskConflictException, ScheduleExceptions.InvalidTimeFormatException {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter start time (HH:MM): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:MM): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        Task task = TaskFactory.createTask(description, startTime, endTime, priority);
        scheduleManager.addTask(task);
        System.out.println("Task added successfully.");
    }

    private void removeTask() throws ScheduleExceptions.TaskNotFoundException {
        System.out.print("Enter task description to remove: ");
        String description = scanner.nextLine();
        scheduleManager.removeTask(description);
        System.out.println("Task removed successfully.");
    }

    private void viewTasks() {
        List<Task> tasks = scheduleManager.viewTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private void markTaskAsCompleted() throws ScheduleExceptions.TaskNotFoundException {
        System.out.print("Enter task description to mark as completed: ");
        String description = scanner.nextLine();
        scheduleManager.markTaskAsCompleted(description);
        System.out.println("Task marked as completed.");
    }

    @Override
    public void update(String message) {
        System.out.println("Notification: " + message);
    }
}
