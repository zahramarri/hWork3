open class A {
    open fun method1(): String {
        return "A1"
    }

    open fun method2(): String {
        return "A2"
    }
}

open class B : A() {
    override fun method2(): String {
        return method1() + "B2"
    }
}

class C : B() {
    override fun method1(): String {
        return "C1"
    }
}

class D : B() {
    override fun method1(): String {
        return "D1"
    }
}

fun main() {
    val elements: Array<A> = arrayOf(D(), A(), C(), B())
    for (i in elements.indices) {
        println(elements[i].method1())
        println(elements[i].method2())
        println()
    }
}
