package days

class Day02 : Day(2) {
    override fun part1() : Any {
        return calcGames(inputList, 1)
    }

    override fun part2() : Any {
        return calcGames(inputList, 2)
    }
}

fun calcGames(inputList: List<String>, part: Int): Int {
    var returnValue = 0
    inputList.forEach { it ->
        val id = it.substring(5, it.indexOf(":")).toInt()
        val reveals = it.substringAfter(": ").split(";").map { it.replace(" ", "") }

        var maxR = 0
        var maxG = 0
        var maxB = 0

        reveals.forEach {
            val parts = it.replace(" ", "").split(",").toTypedArray()
            parts.forEach { part ->
                if (part.contains("red")) {
                    val rVal = part.substring(0, part.indexOf("r")).toInt()
                    if (rVal > maxR) maxR = rVal
                }
                if (part.contains("green")) {
                    val gVal = part.substring(0, part.indexOf("g")).toInt()
                    if (gVal > maxG) maxG = gVal
                }
                if (part.contains("blue")) {
                    val bVal = part.substring(0, part.indexOf("b")).toInt()
                    if (bVal > maxB) maxB = bVal
                }
            }
        }
        if (part == 2) returnValue += maxR * maxG * maxB
        else if(maxR <= 12 && maxG <= 13 && maxB <= 14) returnValue += id
    }
    return returnValue
}