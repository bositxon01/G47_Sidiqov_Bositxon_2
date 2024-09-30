package exam.task4;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task4 {
    static Logger logger = Logger.getLogger(Task4.class.getName());

    public static void main(String[] args) throws IOException {
        Handler handler = new CustomHandler();
        handler.setFormatter(new CustomFormatter());
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);

        try {
            if (new Random().nextBoolean()) {
                throw new RuntimeException("Exception occurred");
            }
        } catch (RuntimeException e) {
            logger.log(Level.SEVERE, "Exception be careful", e);
        }
    }
}
