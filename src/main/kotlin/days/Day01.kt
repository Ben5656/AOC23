package days

class Day01 : Day(1) {
    override fun part1() : Any {
        var output = 0
        inputList.forEach { calibrations ->
            val stripped = calibrations.filter { it.isDigit() }
            val left = stripped.first().toString()
            val right = stripped.last().toString()
            output += (left + right).toInt()
        }
        return output
    }

    override fun part2() : Any {
        var output = 0;
        inputList.forEach { calibrations ->
            val stripped = calibrations.replace("one", "one1one")
                .replace("two", "two2two")
                .replace("three", "three3three")
                .replace("four", "four4four")
                .replace("five", "five5five")
                .replace("six", "six6six")
                .replace("seven", "seven7seven")
                .replace("eight", "eight8eight")
                .replace("nine", "nine9nine").filter { it.isDigit() }
            val left = stripped.first().toString()
            val right = stripped.last().toString()
            output += (left + right).toInt()
        }
        return output
    }
}