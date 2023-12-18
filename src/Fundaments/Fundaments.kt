package Fundaments

fun main (args: Array<String>) {
    println("Pow with Kotlin!")
    /**
     *  Variables and distinct types
     *  */

    // char must contain only one character
    val firstLetter: Char = 'a'

    val myName: String = "Williams"
    val firstApplication: Boolean = true
    val myByte: Byte = 1
    val shorter: Short = 23
    val myInt: Int = 10
    val decimal: Double = 1.923
    var sumDecimal: Double = myInt + decimal
    var sumEntera:Int = decimal.toInt() + myInt
    println("decimal sum es: $sumDecimal")
    println("Integer sum es: $sumEntera")


    /**
     *  Basic Arrays and While
     *  */
    // Defining type and size for a basic Array
    val friends: Array<String> = arrayOf("Cristian", "Roberto", "Eduardo", "Dexter", "Wil")

    // Setting an item of array even when array is declared using VAL
    friends[1] = "Israel"
    // It does not work because friends was declared with size for 5 elements
    // friends[5] = "Daynor"
    var i = 0
    while (i < friends.size) {
        println("Friend ${friends[i]}, position $i")
        i++
    }
    println("My array is ${if (friends.size > 10) "Long" else "Short"}")

    /**
     * Calling Functions
     *  */
    val country = getCountry()
    val city = returnCity()
    println("I live in $country in $city city")

    // Get MAX and MIN between two numbers
    val x = 100
    val y = 73
    println("El mayor es: ${returnMax(x, y)}")
    println("El menor es: ${returnMin(x, y)}")

    /**
     * Loop with For
     */
    playingWithFor()

    /**
     * When - Switch
     */
    val dayOfWeek = getDay(3)
    println("Day: $dayOfWeek")
}

/* Functions */
fun returnCity(): String {
    return "La Paz"
}

// Short Functions
// In several these cases KT know Object type that function will return
fun getCountry() = "Bolivia"

// returning an integer using a function without declare return type
fun returnMax(x: Int, y: Int) = if (x > y) x else y

// returning an integer using a function with declaration of return type
fun returnMin(x: Int, y: Int): Int = if (x < y) x else y


fun playingWithFor() {
    // Go from 1 to 10
    for (i in 1..10) {
        print("$i ")
    }

    // Short syntax
    // 1 to 9
    for (j in 1 until 10) print("$j ")
    // 10 to 1
    for (k in 10 downTo 1) print("$k  ")
    // With 3 steps in each iteration 1,4,7...
    for (l in 1..20 step 3) print("$l ")
    println()

    // Lopping an array
    val friends: Array<String> = arrayOf("Cristian", "Roberto", "Eduardo", "Dexter", "Wil")
    for (friend in friends) {
        print("Friend $friend ")
    }

    println()
    // Accessing to Index of array
    for (indice in friends.indices) {
        println("Index $indice Contains to ${friends[indice]} ")
    }

    println()
    // Accessing to item and index
    for ((index, item) in friends.withIndex()) {
        println("$item is at position: $index")
    }
}

fun getDay(numDay: Int) : String {
    val day: String
    // When as a switch, multiple condition.
    when (numDay) {
        1 -> day = "Monday"
        2 -> day = "Tuesday"
        3 -> day = "Wednesday"
        4 -> day = "Thursday"
        5 -> day = "Friday"
        6, 7 -> day = "Weekend"
        else -> day = "Day Not Exist"
    }
    return day
}
