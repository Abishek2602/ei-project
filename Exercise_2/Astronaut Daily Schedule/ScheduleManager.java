import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<ScheduleObserver> observers;
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) throws ScheduleExceptions.TaskConflictException {
        if (isConflicting(task)) {
            throw new ScheduleExceptions.TaskConflictException("Task conflicts with an existing task.");
        }
        tasks.add(task);
        Collections.sort(tasks);
        notifyObservers("Task added: " + task.getDescription());
        logger.log(Level.INFO, "Task added: " + task.getDescription());
    }

    public void removeTask(String description) throws ScheduleExceptions.TaskNotFoundException {
        boolean removed = tasks.removeIf(task -> task.descriptionMatches(description));
        if (!removed) {
            throw new ScheduleExceptions.TaskNotFoundException("Task not found: " + description);
        }
        notifyObservers("Task removed: " + description);
        logger.log(Level.INFO, "Task removed: " + description);
    }

    public List<Task> viewTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Task> viewTasksByPriority(String priority) {
        return tasks.stream()
                    .filter(task -> task.getPriority().equalsIgnoreCase(priority))
                    .toList();
    }

    public void markTaskAsCompleted(String description) throws ScheduleExceptions.TaskNotFoundException {
        for (Task task : tasks) {
            if (task.descriptionMatches(description)) {
                task.setCompleted(true);
                notifyObservers("Task completed: " + description);
                logger.log(Level.INFO, "Task completed: " + description);
                return;
            }
        }
        throw new ScheduleExceptions.TaskNotFoundException("Task not found: " + description);
    }

    private boolean isConflicting(Task newTask) {
        return tasks.stream().anyMatch(task ->
            (newTask.getStartTime().isBefore(task.getEndTime()) && newTask.getEndTime().isAfter(task.getStartTime())) ||
            (newTask.getStartTime().equals(task.getStartTime()) && newTask.getEndTime().equals(task.getEndTime()))
        );
    }

    public void addObserver(ScheduleObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ScheduleObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (ScheduleObserver observer : observers) {
            observer.update(message);
        }
    }
}
