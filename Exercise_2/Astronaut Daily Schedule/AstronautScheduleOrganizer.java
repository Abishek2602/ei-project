public class AstronautScheduleOrganizer {
    public static void main(String[] args) {
        try {
            ConsoleUI ui = new ConsoleUI();
            ui.run();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
