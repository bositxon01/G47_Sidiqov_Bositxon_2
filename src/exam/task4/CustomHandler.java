package exam.task4;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class CustomHandler extends Handler {

    @Override
    public void publish(LogRecord record) {
        if (isLoggable(record)) {
            String formattedMessage = getFormatter().format(record);
            System.out.println(formattedMessage);
        }
    }


    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}