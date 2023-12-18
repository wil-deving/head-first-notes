package PooAndInheritance

fun main(args: Array<String>) {
    // Declare an array of Animal
    // KT already knows that Hippo and Wolf are Animal type
    val animals = arrayOf(Hippo(), Wolf())

    for (item in animals) {
        item.roam()
        item.eat()
    }

    val wolf = Wolf()
    val hippo = Hippo()

    val vet = Vet()
    vet.giveShot(wolf)
    vet.giveShot(hippo)
}

// Open class converts a class to super class to sub-classes can inherit of this
// Open attribute/method are used to become in mutable to sub-classes can override these
// When attribute or method is not open can not be overridden in sub-classes
open class Animal {
    open val image = ""
    open val food = ""
    open val habitat = ""
    var hunger = 10

    open fun makeNoise() {
        println("The Animal is making a noise")
    }

    open fun eat() {
        println("The Animal is eating")
    }

    open fun roam() {
        println("The Animal is roaming")
    }

    fun sleep() {
        println("The Animal is sleeping")
    }
}

// : PooAndInheritance.Animal(), inherits of Super class PooAndInheritance.Animal
class Hippo : Animal() {
    // override attribute or method of super class
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    // override attribute or method of super class
    override fun makeNoise()  {
        println("Grunt! Grunt!")
    }

    // override attribute or method of super class
    override fun eat() {
        println("The hippo is eating $food")
    }

}

// Inherits of Super class PooAndInheritance.Animal
open class Canine: Animal() {
    // override attribute or method of super class
    override fun roam() {
        println("The canine is roaming")
    }
}

// Inherits of Super class PooAndInheritance.Animal
class Wolf : Canine() {
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise()  {
        println("Hoooooooow!")
    }

    override fun eat() {
        println("The wolf is eating $food")
    }
}

class Vet {
    fun giveShot(animal: Animal) {
        animal.makeNoise()
    }
}