// difference between sum of squares and square of sums

fun main(args: Array<String>) {
    println(squareOfSum(100) - sumOfSquares(100))

}

fun sumOfSquares(limit: Long) = LongRange(1, limit).map { nr -> nr * nr }.sum()

fun squareOfSum(limit: Long): Long {
    val sum = LongRange(1, limit).sum()
    return sum * sum
}