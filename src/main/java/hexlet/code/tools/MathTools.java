package hexlet.code.tools;

import java.util.concurrent.ThreadLocalRandom;

public class MathTools {
    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
