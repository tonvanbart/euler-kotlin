fun main(args: Array<String>) {
    val reduced = Array(1000, { i -> i })
            .filter({ i -> ismulti(i) })
            .reduce { total, next -> total + next }
    println(reduced)
}

fun ismulti(nr : Int ) = nr % 3 == 0 || nr % 5 == 0