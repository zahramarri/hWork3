import kotlin.math.abs

class Rational() {
    var reducedForm = "0/1"
    private var numerator = 0
    private var denominator = 1

    constructor(rationalNumber: String): this() {
        numerator = rationalNumber.split('/')[0].toInt()
        denominator = rationalNumber.split('/')[1].toInt()
        var gCD = 1
        val cD = mutableListOf<Int>()
        for (i in abs(numerator) downTo 1) {
            if (numerator % i == 0) {
                cD.add(i)
            }
        }
        for (j in cD) {
            if (denominator % j == 0) {
                gCD = j
                break
            }
        }
        val dividedNumerator = numerator / gCD
        val dividedDenominator = denominator / gCD
        reducedForm = "$dividedNumerator/$dividedDenominator"
    }

    fun addition(rationalNumber: Rational): Rational {
        val numerator = (this.numerator * rationalNumber.denominator) + (rationalNumber.numerator * this.denominator)
        val denominator = this.denominator * rationalNumber.denominator
        return Rational("$numerator/$denominator")
    }

    fun subtraction(rationalNumber: Rational): Rational {
        val numerator = (this.numerator * rationalNumber.denominator) - (rationalNumber.numerator * this.denominator)
        val denominator = this.denominator * rationalNumber.denominator
        return Rational("$numerator/$denominator")
    }

    fun multiplication(rationalNumber: Rational): Rational {
        val numerator = this.numerator * rationalNumber.numerator
        val denominator = this.denominator * rationalNumber.denominator
        return Rational("$numerator/$denominator")
    }

    fun division(rationalNumber: Rational): Rational {
        val numerator = this.numerator * rationalNumber.denominator
        val denominator = this.denominator * rationalNumber.numerator
        return Rational("$numerator/$denominator")
    }

    fun toFloatingPoint(): Double {
        return numerator.toDouble()/denominator
    }

    fun toMixedNumberString(): String {
        var integer = 0
        var reminder = 0
        if (numerator > denominator) {
            integer = numerator / denominator
            reminder = numerator - (denominator * integer)
        }
        val r = Rational("$reminder/$denominator")
        return "$integer+${r.reducedForm}"
    }
}

fun main() {
    val rationalNumber1 = Rational()
    println(rationalNumber1.reducedForm)
    val rationalNumber2 = Rational("10/4")
    println(rationalNumber2.reducedForm)
    val rationalNumber3 = Rational("9/7")
    println(rationalNumber2.addition(rationalNumber3).reducedForm)
    println(rationalNumber2.subtraction(rationalNumber3).reducedForm)
    println(rationalNumber2.multiplication(rationalNumber3).reducedForm)
    println(rationalNumber2.division(rationalNumber3).reducedForm)
    println(rationalNumber2.toFloatingPoint())
    println(rationalNumber2.toMixedNumberString())
}