// largest product of two 3 digit numbers that is palindromic

fun main(args: Array<String>) {
    var result = 0
    for (i in 100..999) {
        for (j in 100..999) {
            val nr = i * j
            if (palindromic(nr) && nr > result) {
                result = nr
            }
        }
    }
    println(result)

    // or in a slightly more functional way:
    println(Sequence { Products() }.filter { product -> palindromic(product) }.max())
}

fun palindromic(nr: Int) = nr.toString() == nr.toString().reversed()

/**
 * An iterator of products of two 3 digit numbers.
 */
class Products: Iterator<Int> {

    var left: Int = 100

    var right: Int = 100

    override fun hasNext(): Boolean = left <= 999

    override fun next(): Int {
        val result = left * right
        right++
        if (right > 999) {
            left++
            right = 100
        }
        return result
    }
}