

fun List<Ball>.scoreGame() : Int {
    var result = 0
    forEach {result += it.roll.toInt() }
    return result
}