fun main() {
    fun part1(input: List<String>): Int {
        val (numIncreases, lastMeasurement) = input
            .fold(Pair(0, 0)) { sumPair, measurement ->
                when {
                    sumPair.first == 0 && sumPair.second == 0 -> Pair(0, measurement.toInt())
                    measurement.toInt() > sumPair.second -> Pair(sumPair.first + 1, measurement.toInt())
                    else -> Pair(sumPair.first, measurement.toInt())
                }
            }

        return numIncreases
    }

    fun part2(input: List<String>): Int {
        return input.size
//        val (numIncreases, lastWindow, lastMeasurement) = input
//            .fold(Triple(0, Triple(0, 0, 0), 0)) { sumTriple, measurement ->
//                when {
//
//                }
//            }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
