import java.time.LocalTime;

public class Task implements Comparable<Task> {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priority;
    private boolean completed;

    public Task(String description, LocalTime startTime, LocalTime endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = false;
    }

    // Getters and setters
    public String getDescription() { return description; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    @Override
    public int compareTo(Task other) {
        return this.startTime.compareTo(other.startTime);
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s]%s", 
            startTime, endTime, description, priority, 
            completed ? " (Completed)" : "");
    }

    public boolean descriptionMatches(String otherDescription) {
        return this.description.equalsIgnoreCase(otherDescription);
    }
}
