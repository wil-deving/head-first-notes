package PooAndPolymorfism

open class Transport {

}

/**
 * A class can implements N Interfaces
 * A class inherits from only a super class
*/
class Vehicle : Transport(), Roaming, Stopping, Starting, Properties {
    // Override engine from Properties
    override val engine: String
        get() = super.engine

    // Override methods from other interfaces
    override fun roam() {
        println("The vehicle is roaming")
    }

    override fun start() {
        println("The vehicle is starting with $engine")
    }
}

interface Properties {
    /**
     * Exists only a way to declare variables into an interface
     * this variable is treated as an abstract
     * this variable has not a set handling method because it has not a field
     * this variable must be overridden when interface is implemented
     * this value can be called only using get handling
     */
    val engine: String
    get() = "MOTOR V6"
}

interface Stopping {
    fun stop() {
        println("The vehicle is stopping")
    }
}

interface Starting {
    fun start()
}