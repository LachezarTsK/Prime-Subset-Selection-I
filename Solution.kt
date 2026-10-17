
import kotlin.math.sqrt

class Solution {

    private companion object {
        const val MIN_PRIME = 2
    }

    fun maxPrimes(maxValue: Int, maxSum: Int): List<Int> {
        var sumPrimes = 0
        val maxPrimes = mutableListOf<Int>()
        val isPrime = createSieveOfEratosthene(maxValue)

        for (value in MIN_PRIME..maxValue) {
            if (!isPrime[value]) {
                continue
            }
            if (sumPrimes + value > maxSum) {
                break
            }
            sumPrimes += value
            maxPrimes.add(value)
        }
        return maxPrimes
    }

    private fun createSieveOfEratosthene(maxValue: Int): BooleanArray {
        val isPrime = BooleanArray(maxValue + 1) { true }

        for (value in 0..<MIN_PRIME) {
            isPrime[value] = false
        }

        val upperLimit = sqrt(maxValue.toDouble()).toInt()
        for (value in MIN_PRIME..upperLimit) {
            if (!isPrime[value]) {
                continue
            }
            var current = value * value
            while (current <= maxValue) {
                isPrime[current] = false
                current += value
            }
        }
        return isPrime
    }
}
