
package main
import "math"

const MIN_PRIME = 2

func maxPrimes(maxValue int, maxSum int) []int {
    sumPrimes := 0
    maxPrimes := make([]int, 0)
    isPrime := createSieveOfEratosthene(maxValue)

    for value := MIN_PRIME; value <= maxValue; value++ {
        if !isPrime[value] {
            continue
        }
        if sumPrimes + value > maxSum {
            break
        }
        sumPrimes += value
        maxPrimes = append(maxPrimes, value)
    }
    return maxPrimes
}

func createSieveOfEratosthene(maxValue int) []bool {
    isPrime := make([]bool, maxValue + 1)
    for i := range isPrime {
        isPrime[i] = true
    }

    for value := range MIN_PRIME {
        isPrime[value] = false
    }

    upperLimit := int(math.Sqrt(float64(maxValue)))
    for value := MIN_PRIME; value <= upperLimit; value++ {
        if !isPrime[value] {
            continue
        }
        current := value * value
        for current <= maxValue {
            isPrime[current] = false
            current += value
        }
    }
    return isPrime
}
