package com.zhd4.mindgames;

import java.util.Random;

public class Utils {
    public static int getRandomInt(int start, int end) {
        Random random = new Random();
        return random.nextInt(start, end) + 1;
    }
}
