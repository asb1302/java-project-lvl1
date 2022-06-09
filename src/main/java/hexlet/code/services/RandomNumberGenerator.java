package hexlet.code.services;

public final class RandomNumberGenerator implements RandomNumberGeneratorInterface {
    private int maxRandomNumber;
    private int minRandomNumber;

    public RandomNumberGenerator() {
        this.maxRandomNumber = MAX_RANDOM_NUMBER;
        this.minRandomNumber = MIN_RANDOM_NUMBER;
    }

    @Override
    public RandomNumberGeneratorInterface setMinRandomNumber(int randomNumber) {
        this.minRandomNumber = randomNumber;

        return this;
    }

    @Override
    public RandomNumberGeneratorInterface setMaxRandomNumber(int randomNumber) {
        this.maxRandomNumber = randomNumber;

        return this;
    }

    @Override
    public Integer getRandomNumber() {
        return this.minRandomNumber + (int) (Math.random() * this.maxRandomNumber);
    }
}
