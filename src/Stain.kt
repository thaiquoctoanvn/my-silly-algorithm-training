//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val coordinatesNearBy = listOf(
        Pair(0, 1),
        Pair(0, -1),
        Pair(1, 0),
        Pair(-1, 0),
    )

    val squareCountOnEachStain = mutableListOf<Int>()

    println("Input row and column of matrix")
    val m = readln()
    val n = readln()
    println("Input matrix values")
    assert(m.toIntOrNull() != null)
    assert(n.toIntOrNull() != null)

    val inputMatrix = MutableList(m.toInt()) {
        MutableList(n.toInt()) {
            it
        }
    }
    val markMatrix = MutableList(m.toInt()) {
        MutableList(n.toInt()) {
            -1
        }
    }

    println("Matrix length m: ${inputMatrix.size}")

    for (i in 0..<m.toInt()) {
        for (j in 0..<n.toInt()) {
            val num = readln()
            assert(num.toIntOrNull() != null)
            inputMatrix[i][j] = num.toInt()
        }
    }
    println("Review your matrix")
    for (i in 0..<m.toInt()) {
        for (j in 0..<n.toInt()) {
            print("${inputMatrix[i][j]} \t")
        }
        println()
    }

    for (i in 0..<m.toInt()) {
        for (j in 0..<n.toInt()) {
            if (inputMatrix[i][j] == 1 && markMatrix[i][j] != 1) {
                squareCountOnEachStain.add(
                    getSquareOfStain(
                        row = i,
                        column = j,
                        inputMatrix = inputMatrix,
                        markMatrix = markMatrix,
                        coordinatesNearBy = coordinatesNearBy,
                        rowCount = m.toInt(),
                        columnCount = n.toInt(),
                    )
                )
            }
        }
    }

    println("Result")
    squareCountOnEachStain.forEach {
        println(it)
    }
}

fun getSquareOfStain(
    row: Int,
    column: Int,
    inputMatrix: MutableList<MutableList<Int>>,
    markMatrix: MutableList<MutableList<Int>>,
    coordinatesNearBy: List<Pair<Int, Int>>,
    rowCount: Int,
    columnCount: Int,
): Int {
    var squareCount = 0
    val queue = mutableListOf<Pair<Int, Int>>()
    queue.add(Pair(row, column))
    markMatrix[row][column] = 1
    while (queue.isNotEmpty()) {
        val currentRow = queue.first().first
        val currentColumn = queue.first().second
        queue.removeFirst()
        squareCount++
        for (i in coordinatesNearBy.indices) {
            val verticalNearBy = currentRow + coordinatesNearBy[i].first
            val horizontalNearBy = currentColumn + coordinatesNearBy[i].second
            if (verticalNearBy in 0..<rowCount && horizontalNearBy in 0..<columnCount && inputMatrix[verticalNearBy][horizontalNearBy] == 1 && markMatrix[verticalNearBy][horizontalNearBy] != 1) {
                queue.add(Pair(verticalNearBy, horizontalNearBy))
                markMatrix[verticalNearBy][horizontalNearBy] = 1
            }
        }
    }
    return squareCount
}