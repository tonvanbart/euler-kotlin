import kotlin.math.sqrt

// find the largest prime factor of 600851475143

fun main(args: Array<String>) {
    print(primes(600851475143))
}

fun primes(number: Long) : List<Long> {
    var nr = number
    val limit = sqrt(number.toDouble()).toInt() + 1
    val result = ArrayList<Long>()

    for (i in 2..limit) {
        while (nr % i == 0L) {
            result.add(i.toLong())
            nr /= i
        }
    }

    if (nr > 2) {
        result.add(nr)
    }

    return result.distinct()
}
