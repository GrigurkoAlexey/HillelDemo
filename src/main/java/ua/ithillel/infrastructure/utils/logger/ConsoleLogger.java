package ua.ithillel.infrastructure.utils.logger;

public class ConsoleLogger extends TestLogger {

    @Override
    public void log(String message) {
        System.out.println(getCurrentTime() + " [" + getThreadName() + "]: " + message);
    }
}
