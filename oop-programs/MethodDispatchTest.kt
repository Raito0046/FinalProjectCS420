open class C1 {
    open fun initialize() {}
    
    open fun m1(): Int = m2()
    
    open fun m2(): Int = 13
}

open class C2 : C1() {
    override fun m1(): Int = 22
    
    override fun m2(): Int = 23
    
    fun m3(): Int = super.m1()
}

class C3 : C2() {
    override fun m1(): Int = 32
    
    override fun m2(): Int = 33
}

fun main() {
    val o3 = C3()
    val result = o3.m3()
    
    println("o3.m3() result: $result")
    println("\nExplanation:")
    println("o3.m3() calls super.m1()")
    println("super.m1() is C2.m1(), which returns 22")
    println("Even though o3 is C3 instance, super constrains dispatch to C2")
}
