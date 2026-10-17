
#include <cmath>
#include <vector>
using namespace std;

class Solution {

    static const int  MIN_PRIME = 2;

public:
    vector<int> maxPrimes(int maxValue, int maxSum) {
        int sumPrimes = 0;
        vector<int> maxPrimes;
        vector<bool> isPrime = createSieveOfEratosthene(maxValue);

        for (int value = MIN_PRIME; value <= maxValue; ++value) {
            if (!isPrime[value]) {
                continue;
            }
            if (sumPrimes + value > maxSum) {
                break;
            }
            sumPrimes += value;
            maxPrimes.push_back(value);
        }
        return maxPrimes;
    }

private:
    static vector<bool> createSieveOfEratosthene(int maxValue) {
        vector<bool> isPrime(maxValue + 1, true);

        for (int value = 0; value < MIN_PRIME; ++value) {
                isPrime[value] = false;
        }

        int upperLimit = sqrt(maxValue);
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
};
