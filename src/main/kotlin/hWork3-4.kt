import java.util.*

fun main() {
    println("Please enter a NUMBER.")
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val matrix = mutableListOf<MutableList<Int>>()
    println("Please enter $n numbers between -9 and 9 in $n rows. Don't forget the white spaces.")
    for (i in 1..n) {
        val row = mutableListOf<Int>()
        val input = readLine().toString().split(" ")
        for (j in input) {
            row.add(j.toInt())
        }
        matrix.add(row)
    }

    val clockSum = mutableListOf<Int>()
    for (i in 0..n - 3) { // آی امین آرایه، آی امین ردیف (ستون)
        for (k in 0..n - 3) { // ردیف، کا امین ستون، عناصر داخل آرایه آی ام
            var sum = 0
            for (j in k..k + 2) { // ردیف اول ساعت شنی
                sum += matrix[i][j] // عنصر جی ام از آرایه آی ام
            }
            sum += matrix[i + 1][k + 1] // عنصر کا+1 ام از آرایه آی+1 ام
            for (j in k..k + 2) {
                sum += matrix[i + 2][j] // ردیف سوم ساعت شنی
            }
            clockSum.add(sum)
        }
    }
    println(clockSum.maxOrNull())
}