
using System;

public class Solution
{
    private static readonly int MIN_PRIME = 2;

    public IList<int> MaxPrimes(int maxValue, int maxSum)
    {
        int sumPrimes = 0;
        List<int> maxPrimes = new List<int>();
        bool[] isPrime = CreateSieveOfEratosthene(maxValue);

        for (int value = MIN_PRIME; value <= maxValue; ++value)
        {
            if (!isPrime[value])
            {
                continue;
            }
            if (sumPrimes + value > maxSum)
            {
                break;
            }
            sumPrimes += value;
            maxPrimes.Add(value);
        }
        return maxPrimes;
    }

    private static bool[] CreateSieveOfEratosthene(int maxValue)
    {
        bool[] isPrime = new bool[maxValue + 1];
        Array.Fill(isPrime, true);
        for (int value = 0; value < MIN_PRIME; ++value)
        {
            isPrime[value] = false;
        }

        int upperLimit = (int)Math.Sqrt(maxValue);
        for (int value = MIN_PRIME; value <= upperLimit; ++value)
        {
            if (!isPrime[value])
            {
                continue;
            }
            int current = value * value;
            while (current <= maxValue)
            {
                isPrime[current] = false;
                current += value;
            }
        }
        return isPrime;
    }
}
