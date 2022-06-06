package hexlet.code.services;

public interface RandomNumberGeneratorInterface {
    int MIN_RANDOM_NUMBER = 1;
    int MAX_RANDOM_NUMBER = 10;

    int getRandomNumber();

    RandomNumberGeneratorInterface setMinRandomNumber(int minRandomNumber);

    RandomNumberGeneratorInterface setMaxRandomNumber(int maxRandomNumber);
}
