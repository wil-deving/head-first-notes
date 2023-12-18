package PooAndInheritance

fun main(args: Array<String>) {
    val creatures = arrayOf(
            Vampire(),
            Dragon(),
            Monster()
    )

    for (item in creatures) {
        item.frighten()
    }
}

open class Monster {
    open fun frighten() : Boolean {
        println("Aargh!!!")
        return true
    }
}

class Vampire : Monster() {
    override fun frighten() : Boolean {
        println("Fancy a bite?")
        return true
    }
}

class Dragon : Monster() {
    override fun frighten() : Boolean {
        println("Fire!")
        return true
    }

}