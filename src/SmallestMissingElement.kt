/*
* Given 2 array A and B. Each one consists of N positive integers
* Print the smallest number which is present in A but missing in B
* If no such element exists, print -1
* Test case 1: 6 - 1 2 4 5 6 5 - 2 5 8 5 1 5
* Test case 2: 7 - 1 2 4 5 6 3 5 - 2 5 8 5 1 5 9*/

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.trim().split(" ").map { it.toInt() }.toTypedArray()
    val b = readLine()!!.trim().split(" ").map { it.toInt() }.toTypedArray()

    println("")
    println(solve(n, a, b))
}

fun solve(n: Int, a: Array<Int>, b: Array<Int>): Int {
    var result = -1

    for (i in 0..<n) {
        var count = 0
        for (j in 0 ..<n) {
            if (a[i] == b[j]) {
                break
            }
            count++
        }

        if (count == n && (result == -1 || a[i] < result)) {
            result = a[i]
        }
    }

    return result
}