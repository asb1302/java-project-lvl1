package hexlet.code.services;

public final class RandomNumberGenerator implements RandomNumberGeneratorInterface {
    @Override
    public Integer getRandomNumber(int minRandomNumber, int maxRandomNumber) {
        return minRandomNumber + (int) (Math.random() * maxRandomNumber);
    }
}
