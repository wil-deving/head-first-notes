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
    println("r1 hash code: ${r2.hashCode()}")

    // This show a distinct hashCode because title was changed
    println("r1 hash code: ${r3.hashCode()}")

    // This show contain as text
    println("r1 to String: ${r1.toString()}")

    // TRUE, porque son objetos que tienen el mismo contenido en sus propiedades
    println("r1 == r2? ${r1 == r2}")

    // FALSE, porque === valida si son el mismo objeto, en este caso son distintos
    println("r1 === r2? ${r1 === r2}")

    // FALSE, porque cambiamos el title al crear r3 por copy()
    println("r1 == r3? ${r1 == r3}")

    /* Destructurando un objeto. (Solo para DATA CLASS)
    *  Podemos sacar en variables los valores de las propiedades de un objeto;
    *  se destructura en el orden en el que sus propiedades esten en el constructor
    *  de su DATA CLASS.
    *  */
    val (titulo, ingredientePrincipal, esVegetariano, dificultad) = r1
    // Es lo mismo a...
    // val titulo = r1.title
    // val esVegetariano = r1.isVegetarian ...
    println("title is $titulo and vegetarian is $esVegetariano")

    // Destructurando un array<Object> con for
    val recipes = arrayOf(r1, r2 ,r3)
    // Destructuracion en orden, por las propiedades del objeto
    for ((titulo, principalIngredient) in recipes) println("title: $titulo ingrediente: $principalIngredient")

    // Creamos tres variables con referencia al mismo Objeto
    val r5 = Recipe("Sushi", "Fish")
    val r6 = r5
    val r7 = r6
    // True, porque hacen referencia al mismo objeto
    if (r5 === r7) println("Same Object's references") else println("Different Objects")

    // Creamos un objeto de Mushroom utilizando su constructor principal con dos argumentos
    val m1 = Mushroom(6, false)
    println("m1 size is ${m1.size} and is magic is ${m1.isMagic}")

    // Creamos un objeto de Mushroom utilizando su constructor secundario con un argumento
    val m2 = Mushroom(true)
    println("m2 size is ${m2.size} and is magic is ${m2.isMagic}")

    // Sobrecarga de funciones
    // Utilizamos la misma funcion addNumbers() con sobrecarga
    // Una se invoca segun le inviemos enteros
    println("sumando con addNumbers(enteros) ${addNumbers(2,5)}")
    // Esta se invoca cuando le enviamos doubles
    println("sumando con addNumbers(decimales) ${addNumbers(1.6,7.3)}")

}

/*
* Estos modelos de classes se utiliza para objetos de informacion,
* Solo pueden ser tomados como Superclases
* No pueden ser Abstract u Open
* Pueden implementar funciones de interfaces
*
* isVegetarian y difficulty tienen valores por defecto
* */
data class Recipe(val title: String,
                  val mainIngredient: String,
                  val isVegetarian: Boolean = false,
                  val difficulty: String = "Easy")

/*
* size tiene el valor por defecto de 1
*  */
class Mushroom(val size: Int = 1, val isMagic: Boolean) {

    // Cuando utilizamos el constructor secundario N
    // Recibimos un parametro bool
    /* Sobrecargamos el constructor utilizando THIS para invocar size del
    *  constructor principal y darle el valor de 0
    */
    constructor(isMagic_param: Boolean) : this(0, isMagic_param) {

    }
}

// Creamos una funcion con valores por defecto en sus parametros
fun findRecipes(title: String = "",
                ingredient: String = "",
                isVegetarian: Boolean = false,
                difficulty: String = "") : Array<Recipe> {
    return arrayOf(Recipe(title, ingredient, isVegetarian, difficulty))
}

/*
* Puede existir sobrecarga de funciones, se invocaran segun le enviamos sus parametros:
* por numero de parametros
* por tipo de parametros
*
* NO se puede sobrecargar una funcion dandole el mismo numero de parametros y del mismo tipo
* */
fun addNumbers(a: Int, b: Int) : Int {
    return a + b
}

fun addNumbers(a: Double, b: Double) : Double {
    return a + b
}