open class C1 {
    open var x: Int = 0
    open var y: Int = 0

    open fun initialize() {}

    fun setx1(v: Int) {
        x = v
    }

    fun sety1(v: Int) {
        y = v
    }

    fun getx1(): Int = x
    fun gety1(): Int = y
}

class C2 : C1() {
    override var y: Int = 0  // Override parent's y

    fun sety2(v: Int) {
        this.y = v
    }

    fun getx2(): Int = x
    fun gety2(): Int = this.y
}

fun main() {
    val o2 = C2()
    o2.setx1(101)
    o2.sety1(102)
    o2.sety2(999)

    println("getx1(): ${o2.getx1()}")
    println("gety1(): ${o2.gety1()}")
    println("getx2(): ${o2.getx2()}")
    println("gety2(): ${o2.gety2()}")

    println("\nResult: [${o2.getx1()}, ${o2.gety1()}, ${o2.getx2()}, ${o2.gety2()}]")
}
