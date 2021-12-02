fun main() {
    fun part1(input: List<String>): Int {
        val (numIncreases, lastMeasurement) = input
            .fold(Pair(0, 0)) { acc, measurement ->
                when {
                    acc.first == 0 && acc.second == 0 -> Pair(0, measurement.toInt())
                    measurement.toInt() > acc.second -> Pair(acc.first + 1, measurement.toInt())
                    else -> Pair(acc.first, measurement.toInt())
                }
            }

        return numIncreases
    }

    fun part2(input: List<String>): Int {
        val (numIncreases, lastWindow) = input.fold(Pair(0, Triple(0, 0, 0))) { acc, measurement ->
            val lastWindow = acc.second
            val nextWindow = Triple(lastWindow.second, lastWindow.third, measurement.toInt())
            
            when {
                lastWindow.toList().any { x -> x == 0 } -> Pair(0, nextWindow)
                nextWindow.toList().reduce { x, i -> x + i } > lastWindow.toList().reduce { y, i -> y + i } ->
                    Pair(acc.first + 1, nextWindow)
                else -> Pair(acc.first, nextWindow)
            }
        }

        return numIncreases
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
