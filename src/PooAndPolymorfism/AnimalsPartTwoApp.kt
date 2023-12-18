package PooAndPolymorfism

fun main(args: Array<String>) {

    val animals = arrayOf(Hippo(), Wolf(), Dog())
    for (item in animals) {
        item.roam()
        item.eat()
    }

    println("Noises.....")
    val vet = Vet()

    val wolf = Wolf()
    val dog = Dog()
    val hippo = Hippo()
    vet.giveShot(wolf)
    vet.giveShot(dog)
    vet.giveShot(hippo)

    println("Roaming.....")

    // This array can be declared because all items implements
    // Roaming interface, so all items can call roam() method
    val roamables = arrayOf(Hippo(), Wolf(), Vehicle())
    for (item in roamables) {
        item.roam()
        // But only items that are Animal Type can be call eat() method
        if (item is Animal) {
            item.eat()
        }
        if (item is Vehicle) {
            item.start()
            item.stop()
        }
    }
}

/**
 * Abstract Elements
 */
// Abstract classes can not be instanced
// Abstract classes can have abstract and concrete attributes and methods
// Concrete classes can NOT have abstract attributes and methods
// This class is implementing Roaming Interface
abstract class Animal : Roaming {
    // Abstract attributes does not have handling get and set
    abstract val image: String
    abstract val food: String
    abstract val habitat: String

    // concrete attribute
    val hunger = 10

    // Abstract functions does NOT have BODY
    abstract fun makeNoise()

    // Abstract functions does NOT have BODY
    abstract fun eat()

    // Implementation from roam() from Interface
    override fun roam() {
        println("The Animal is roaming")
    }

    fun sleep() {
        println("The Animal is sleeping")
    }
}

/**
 * Concrete Elements inherits Abstract Elements
 *
 * Rules:
 * 1. A Concrete class always must override all abstract attributes or methods
 * when inherits from an abstract class and its abstract attributes
 * and methods have not been overridden in another sub class
 */
class Hippo: Animal() {
    // override attributes
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    // override methods
    override fun makeNoise()  {
        println("Grunt! Grunt!")
    }

    override fun eat() {
        println("The hippo is eating $food")
    }
}

/**
 * 2. As this class is an Abstract class does not need to override
 * abstract attributes and methods of its super class
 */
/* Esta clase hereda a otra y en esa CLASE se sobrescriben las
* propiedades y funciones de la superclase abstracta, por ello
* no da ningun error.
*  */
abstract class Canine: Animal() {

    abstract fun isDomestic() : Boolean

    override fun roam() {
        println("The canine is roaming")
    }
}

/**
 * 2. As This Class inherits from an abstract class Canine that
 * inherits from another abstract class Animal, Wolf MUST override
 * abstract attributes and methods from Animal and Canine
 */
class Wolf : Canine() {
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise() {
        println("Hoooooow!!!")
    }

    override fun eat() {
        println("The wolf is eating $food")
    }

    override fun isDomestic() : Boolean = false

}

/**
 * 2. As This Class inherits from an abstract class Canine that
 * inherits from another abstract class Animal, DOG MUST override
 * abstract attributes and methods from Animal and Canine
 */
class Dog : Canine() {
    override val image = "dog.jpg"
    override val food = "meat"
    override val habitat = "House"

    override fun makeNoise() {
        println("Wooof!!!")
    }

    override fun eat() {
        println("The dog is eating $food")
    }

    override fun isDomestic() : Boolean = true

}

class Vet {
    fun giveShot(animal: Animal) {
        animal.makeNoise()
    }
}