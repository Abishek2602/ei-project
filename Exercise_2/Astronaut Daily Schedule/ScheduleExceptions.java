public class ScheduleExceptions {
    public static class TaskConflictException extends Exception {
        public TaskConflictException(String message) {
            super(message);
        }
    }

    public static class TaskNotFoundException extends Exception {
        public TaskNotFoundException(String message) {
            super(message);
        }
    }

    public static class InvalidTimeFormatException extends Exception {
        public InvalidTimeFormatException(String message) {
            super(message);
        }
    }
}
