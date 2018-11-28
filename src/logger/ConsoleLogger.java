package logger;

public class ConsoleLogger implements Logger {

    @Override
    public void info(String category, String message) {
        System.out.println(message);
    }

    @Override
    public void error(String category, String message) {
        System.err.println(message);
    }
}