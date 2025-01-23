import kotlin.time.measureTime

fun measureExecutionTime(body: () -> Unit) {
    val timeTaken = measureTime {
        body.invoke()
    }
    println("Execution time: $timeTaken")
}