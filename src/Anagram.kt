/*
* Given 3 string containing lower case characters only
* Print YES if all of them are anagrams of each other else NO
* A string A is an anagram of string B, if we can re-arrange the letters in string A
* and get the exact string B
* Test case: aabc baac baca -> true*/

fun main() {
    val s1 = readLine()!!.trim()
    val s2 = readLine()!!.trim()
    val s3 = readLine()!!.trim()

    measureExecutionTime {
        if (solve(s1, s2) && solve(s2, s3)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

fun solve(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) {
        return false
    }
    val checker = HashMap<Char, Int>()
    s1.forEach {
        if (checker[it] == null) {
            checker[it] = 1
        } else {
            checker[it] = checker[it]!! + 1
        }
    }
    println(checker)
    for (i in s2.indices) {
        if (checker[s2[i]] != null) {
            checker[s2[i]] = checker[s2[i]]!! - 1
        }
    }

    println(checker)

    return checker.values.all { it == 0 }
}