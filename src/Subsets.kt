/*
* Print all subsets of a given set or array
* Test case: [1, 2, 3] -> [1], [2], [3], [1,2], [1,3], [2,3]*/

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    assert(a.size == n)

    solve(a)
}

fun solve(input: IntArray) {
    val result = mutableListOf<List<Int>>()
    val a = listOf<Int>()

    findSubset(input, result, a, 0)

    result.forEach {
        println(it)
    }
}

fun findSubset(input: IntArray, result: MutableList<List<Int>>, previousSubset: List<Int>, startIndex: Int) {
    result.add(previousSubset.map { it })
    println("--$result")
    val subset = mutableListOf<Int>()

    for (i in startIndex..<input.size) {
        subset.add(input[i])
        findSubset(input, result, subset, i + 1)


    }

}