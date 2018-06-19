package task4;

import java.util.Random;

public class Helper {
    static Random random = new Random();

    public static Integer randomInteger(int max) {
        return random.nextInt(max + 1);
    }

    public static String randomString() {
        String string = "TestString";
        return string + randomInteger(99999999);
    }

    public static Double randomDouble(Double min, Double max){
        return min + (max - min) * random.nextDouble();
    }
}