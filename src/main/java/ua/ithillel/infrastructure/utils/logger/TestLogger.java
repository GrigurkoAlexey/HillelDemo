package ua.ithillel.infrastructure.utils.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestLogger {

    public abstract void log(String message);

    protected String getThreadName() {
        return Thread.currentThread().getName();
    }

    protected String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        return sdf.format(new Date());
    }
}
