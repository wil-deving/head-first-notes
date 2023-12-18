package Fundaments

fun main(args: Array<String>) {
    // Declare several arrays of distinct types
    val myBools = ArrayList<Boolean>()
    val myInts = ArrayList<Int>()
    val myDoubles = ArrayList<Double>()
    val myStrings = ArrayList<String>()
    val people = ArrayList<Person>()

    // adding elements to before arrays
    for (i in 1..10) {
        if (i % 2 == 0) myBools.add(true) else myBools.add(false)
        myInts.add(i)
        myDoubles.add(1000.00)
        myStrings.add("CLI-${if (i % 2 == 0) "PAR" else "IMPAR"}-00$i")
    }

    // Adding items to People array with items from Other Arrays
    for (ind in myStrings.indices) {
        people.add(Person(myStrings[ind], myInts[ind], myDoubles[ind], myBools[ind]))
    }

    // Showing all data of People array
    people.forEach {
        println("id: ${it.id} | number: ${it.numberClient} | payment: ${it.payment} Bs. | par: ${it.evenClient}")
    }

    println("----------------------------------------------------")

    // Sort People Array by id
    people.sortBy { it.id }
    people.forEach {
        println("id: ${it.id} | number: ${it.numberClient} | payment: ${it.payment} Bs. | par: ${it.evenClient}")
    }

    // It removes item 2 of list
    println("----------------------------------------------------")

    people.removeAt(2)
    people.forEach {
        println("id: ${it.id} | number: ${it.numberClient} | payment: ${it.payment} Bs. | par: ${it.evenClient}")
    }
}

// Clase base en las que se crearan los objetos persona
class Person(val id: String,
             val numberClient: Int,
             val payment: Double,
             val evenClient: Boolean) {
}