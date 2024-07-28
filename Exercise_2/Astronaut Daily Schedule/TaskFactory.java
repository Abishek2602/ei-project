import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority) 
            throws ScheduleExceptions.InvalidTimeFormatException {
        try {
            LocalTime start = LocalTime.parse(startTime);
            LocalTime end = LocalTime.parse(endTime);
            return new Task(description, start, end, normalizePriority(priority));
        } catch (DateTimeParseException e) {
            throw new ScheduleExceptions.InvalidTimeFormatException("Invalid time format: " + e.getMessage());
        }
    }

    private static String normalizePriority(String priority) {
        String normalizedPriority = priority.toLowerCase();
        switch (normalizedPriority) {
            case "high":
            case "medium":
            case "low":
                return normalizedPriority;
            default:
                return "medium"; // Default to medium if invalid priority is provided
        }
    }
}
