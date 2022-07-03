package hexlet.code.services;

public class RandomNumberGenerator {
    public static Integer getRandomNumber(int minRandomNumber, int maxRandomNumber) {
        return minRandomNumber + (int) (Math.random() * maxRandomNumber);
    }
}
