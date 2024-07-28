public class Logger {
    private static Logger logger;

    private Logger() {
        // private constructor
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

