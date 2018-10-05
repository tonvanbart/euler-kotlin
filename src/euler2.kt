fun main(args: Array<String>)  {

    val reduced = Sequence { LimitedFibo(4000000) }
            .filter { nr -> nr % 2 == 0 }
            .reduce { a, b -> a + b }
    println(reduced)

    val total = Sequence { Fibonacci() }
            .filter { nr -> nr % 2 == 0 }
            .takeWhile { nr -> nr < 4000000 }
            .sum()
    println(total)
}

/**
 * Helper class which provides an Iterator of Fibonacci numbers, up to the given limit.
 */
class LimitedFibo(val limit: Int) : Iterator<Int> {
    private var nextPair = Pair(0, 1)

    override fun hasNext(): Boolean = nextPair.second < limit

    override fun next(): Int {
        nextPair = Pair(nextPair.second, nextPair.second + nextPair.first)
        return nextPair.second
    }
}

/**
 * An infinite Iterator of Fibonacci numbers.
 */
class Fibonacci : Iterator<Int> {
    private var nextPair = Pair(0, 1)

    override fun hasNext(): Boolean = true

    override fun next(): Int {
        nextPair = Pair(nextPair.second, nextPair.second + nextPair.first)
        return nextPair.second
    }
}
