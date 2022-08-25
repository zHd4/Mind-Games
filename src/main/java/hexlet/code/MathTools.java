package hexlet.code;

import java.util.Random;

public class MathTools {
    public static int randomInt(int range) {
        return new Random().nextInt(range);
    }
}
