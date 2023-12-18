package PooAndPolymorfism

/**
 * Interfaces can not inherit
 * Interfaces can not be instanced
 * Interfaces have not constructor
 */
interface Roaming {
    /**
     * When a method have NOT BODY it is treated as an abstract method
     * so, it needs to be overridden
     */
    fun roam()

    /**
     * When a method have a body is treated as concrete method
     * do it does not need to be overridden
     */
    fun anotherRoam() {

    }
}