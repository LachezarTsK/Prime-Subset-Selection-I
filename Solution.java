
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static final int MIN_PRIME = 2;

    public List<Integer> maxPrimes(int maxValue, int maxSum) {
        int sumPrimes = 0;
        List<Integer> maxPrimes = new ArrayList<>();
        boolean[] isPrime = createSieveOfEratosthene(maxValue);

        for (int value = MIN_PRIME; value <= maxValue; ++value) {
            if (!isPrime[value]) {
                continue;
            }
            if (sumPrimes + value > maxSum) {
                break;
            }
            sumPrimes += value;
            maxPrimes.add(value);
        }
        return maxPrimes;
    }

    private static boolean[] createSieveOfEratosthene(int maxValue) {
        boolean[] isPrime = new boolean[maxValue + 1];
        Arrays.fill(isPrime, true);
        for (int value = 0; value < MIN_PRIME; ++value) {
            isPrime[value] = false;
        }

        int upperLimit = (int) Math.sqrt(maxValue);
        for (int value = MIN_PRIME; value <= upperLimit; ++value) {
            if (!isPrime[value]) {
                continue;
            }
            int current = value * value;
            while (current <= maxValue) {
                isPrime[current] = false;
                current += value;
            }
        }
        return isPrime;
    }
}
