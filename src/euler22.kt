import java.io.File

fun readfile(path: String) : List<String> {
    println(File(path).absolutePath)
    val bufferedReader = File(path).bufferedReader()
    return bufferedReader
            .use { it.readText() }
            .split(",")
            .sorted()
}

fun nameNumValue(name: String): Int =
        name.removeSurrounding("\"")
        .map{ nc -> nc.toInt() - 64 }
        .sum()

fun scoreName(name: String, position: Int): Int =
        position * nameNumValue(name)


fun main(args: Array<String>) {
    val sortedNames = readfile("src/p022_names.txt")
    var position = 1;
    val total = sortedNames.map { name -> scoreName(name, position++) }.sum()
    println(total)
}