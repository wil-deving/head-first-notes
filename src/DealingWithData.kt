fun main(args: Array<String>) {
    // Create 2 distinct objects but the same values
    val r1 = Recipe("Thai Curry", "Chicken",false)

    // Create a Recipe Setting specific values by reference
    // The 2 attributes that are not sending to constructor will be set with default values
    val r2 = Recipe(title = "Thai Curry", mainIngredient = "Chicken")

    // Create a copy based in r1 but with another title
    // set attribute title is optional
    val r3 = r1.copy(title = "Chicken Bhuna")

    // these 2 hashCodes has the same value because they have the same values
    println("r1 hash code: ${r1.hashCode()}")
    println("r2 hash code: ${r2.hashCode()}")

    // This show a distinct hashCode because title was changed
    println("r3 (copy of r1) hash code: ${r3.hashCode()}")

    // This show contain as text
    println("r1 to String: ${r1.toString()}")

    // TRUE, because 2 objects has the same values into attributes
    println("r1 == r2? ${r1 == r2}")

    // FALSE, because 2 objects are different instances of the same object
    println("r1 === r2? ${r1 === r2}")

    // FALSE, because title was changed when r1 was copying from r3
    println("r1 == r3? ${r1 == r3}")

    /* Destructuring an object (Only for DATA CLASSES)
    *  It can destructure attribute by attribute in the same order that attributes are
    * declared in its constructor
    *  */
    val (titulo, ingredientePrincipal, esVegetariano, dificultad) = r1
    // The same that ...
    // val titulo = r1.title
    // val esVegetariano = r1.isVegetarian ...
    println("title is $titulo and vegetarian is $esVegetariano")

    // Destructuring an array<Object> using for
    val recipes = arrayOf(r1, r2 ,r3)
    // Destructuring Object attributes in the same constructor order
    for ((titulo, principalIngredient) in recipes)
        println("title: $titulo ingrediente: $principalIngredient")

    // Create 3 variables that refer to the same object
    val r5 = Recipe("Sushi", "Fish")
    val r6 = r5
    val r7 = r6
    // True, because r5 and r7 refer the same object
    if (r5 === r7) println("Same Object's references") else println("Different Objects")

    // Create a Mushroom by using constructor with 2 args
    val m1 = Mushroom(6, false)
    println("m1 size is ${m1.size} and is magic is ${m1.isMagic}")

    // Create a Mushroom by using secondary constructor with 1 arg
    val m2 = Mushroom(true)
    println("m2 size is ${m2.size} and is magic is ${m2.isMagic}")

    // Functions Overload
    // calling overload function addNumbers()
    // Call sending integers
    println("sumando con addNumbers(enteros) ${addNumbers(2,5)}")
    // Call sending doubles
    println("sumando con addNumbers(decimales) ${addNumbers(1.6,7.3)}")

}

/*
* These type of classes are used for DTOs or to store information
* They can not be superclasses
* They can not be Abstract u Open
* They can implement functions from interfaces
*
* isVegetarian y difficulty have default values
* */
data class Recipe(val title: String,
                  val mainIngredient: String,
                  val isVegetarian: Boolean = false,
                  val difficulty: String = "Easy")

/*
* size has default value = 1
*  */
class Mushroom(val size: Int = 1, val isMagic: Boolean) {

    /**
     * constructors overloading
     * main constructor receives two parameters
     * secondary constructor receives one parameter
     * secondary constructor calls main constructor sending size = 0 and
     * its received parameter, that is to say, two parameters
     */
    constructor(isMagic_param: Boolean) : this(0, isMagic_param) {

    }
}

// Create a function with parameters that have default values
fun findRecipes(title: String = "",
                ingredient: String = "",
                isVegetarian: Boolean = false,
                difficulty: String = "") : Array<Recipe> {
    return arrayOf(Recipe(title, ingredient, isVegetarian, difficulty))
}


/**
 * There may be overload of functions when each function declaration:
 * has different quantity of parameters
 * has the same number of parameters but different type of parameters
 */
fun addNumbers(a: Int, b: Int) : Int {
    return a + b
}

fun addNumbers(a: Double, b: Double) : Double {
    return a + b
}