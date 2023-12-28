package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomInt(int start, int end) {
        Random random = new Random();
        return random.nextInt(start, end) + 1;
    }
}
