/*
* Check if sum of all divisors of a number
* is equal with itself (the divisors exclude itself)
* Test case: 100 1 2 3 12 5 6*/

fun main() {
    val inputNumbers = readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray()
    inputNumbers.forEach {
        if (isPerfect(it)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

fun isPerfect(n: Int): Boolean {
    if (n <= 1) {
        return false
    }

    var sum = 1

    for (i in 2..<n) {
        if (n % i == 0) {
            sum += i
        }
    }

    return sum == n
}