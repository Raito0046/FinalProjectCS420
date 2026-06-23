open class C1Dispatch {
    open fun initialize() {}

    open fun m1(): Int = m2()

    open fun m2(): Int = 13
}

open class C2Dispatch : C1Dispatch() {
    override fun m1(): Int = 22

    override fun m2(): Int = 23

    fun m3(): Int = super.m1()
}

class C3Dispatch : C2Dispatch() {
    override fun m1(): Int = 32

    override fun m2(): Int = 33
}

fun main() {
    val o3 = C3Dispatch()
    val result = o3.m3()

    println("o3.m3() result: $result")
    println("\nExplanation:")
    println("o3.m3() calls super.m1()")
    println("Even with super.m1(), the actual instance (C3Dispatch) is used")
    println("So C3Dispatch.m1() is called, which returns 33")
    println("This demonstrates Dynamic Method Dispatch in Kotlin")
}
