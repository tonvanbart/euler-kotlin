import java.lang.Math.pow

// a < b < c
// and a**2 + b**2 = c**2
// and a+b+c == 1000

fun isPytTriplet(a: Int, b:Int, c:Int) = (a*a + b*b) == c*c

fun main(args: Array<String>) {
    for (a in 1..1000) {
        for (b in a..1000) {
            for (c in b..1000) {
                if ((a+b+c == 1000) && isPytTriplet(a,b,c)) {
                    println("a=$a, b=$b, c=$c, sum=${a+b+c} product=" + (a*b*c))
                }
            }
        }
    }
}