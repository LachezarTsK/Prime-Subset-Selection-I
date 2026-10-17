
/**
 * @param {number} maxValue
 * @param {number} maxSum
 * @return {number[]}
 */
var maxPrimes = function (maxValue, maxSum) {
    let sumPrimes = 0;
    const maxPrimes = new Array();
    const isPrime = createSieveOfEratosthene(maxValue);

    for (let value = Util.MIN_PRIME; value <= maxValue; ++value) {
        if (!isPrime[value]) {
            continue;
        }
        if (sumPrimes + value > maxSum) {
            break;
        }
        sumPrimes += value;
        maxPrimes.push(value);
    }
    return maxPrimes;
};

/**
 * @param {number} maxValue
 * @return {boolean[]}
 */
function createSieveOfEratosthene(maxValue) {
    const isPrime = new Array(maxValue + 1).fill(true);

    for (let value = 0; value < Util.MIN_PRIME; ++value) {
        isPrime[value] = false;
    }

    const upperLimit = Math.floor(Math.sqrt(maxValue));
    for (let value = Util.MIN_PRIME; value <= upperLimit; ++value) {
        if (!isPrime[value]) {
            continue;
        }
        let current = value * value;
        while (current <= maxValue) {
            isPrime[current] = false;
            current += value;
        }
    }
    return isPrime;
}

class Util {
    static  MIN_PRIME = 2;
}
