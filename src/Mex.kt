/*
* Given an array A of size n. Print MEX of all the prefix arrays of the given array
* Prefix array is sub-array that start from index 0 and its length is step of i = 0 to inclusive size of array A for each prefix array
* Ex: Given array [2, 1, 0, 2] -> prefix arrays include [2], [2, 1], [2, 1, 0], [2, 1, 0, 2]
* MEX (minimum excluded) of an array is the smallest NON-NEGATIVE integer that does not belong to the arrays
* Ex [2, 2, 1] -> 0, because 0 does not belong to the array
* Ex [3, 1, 0, 1] -> 2, because 0, 1 belong to the array
* Ex [0, 3, 1, 2] -> 4 because 0, 1, 2, 3 belong to the array
* It is worth mentioning that the MEX of an array of size n is always between 0 and n inclusive
*
* Test case n = 3, A = [2, 1, 0]
* -> prefix array 1 = [2], MEX = 0
* -> prefix array 2 = [2, 1], MEX = 0
* -> prefix array 3 = [2, 1, 0] , MEX = 3
* -> the final result should be 0, 0, 3*/

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
    assert(n == a.size)

    measureExecutionTime {
        solve(n, a)
    }
}

fun solve(n: Int, a: Array<Int>) {
    val prefixArrays = mutableListOf<List<Int>>()

    for (i in 0..<n) {
        val prefixArray = mutableListOf<Int>()
        for (j in 0..i) {
            prefixArray.add(a[j])
        }
        prefixArrays.add(prefixArray)
    }

    println(prefixArrays)

    for (i in prefixArrays.indices) {
        val max = findMax(prefixArrays[i])
        // Suppose that we cannot find any minimum number that does not belong to the prefix
        // So the number must be max + 1
        var min = max + 1

        for (k in 0..max) {

            var count = 0

            for (j in 0..<prefixArrays[i].size) {

                if (prefixArrays[i][j] == k) {
                    break
                }
                count++
            }
            if (count == prefixArrays[i].size && k < min) {
                min = k
            }
        }

        println(min)
    }
}

fun findMax(a: List<Int>): Int {
    var max = a[0];
    for (i in 1..<a.size) {
        if (a[i] > max) {
            max = a[i]
        }
    }
    return max
}