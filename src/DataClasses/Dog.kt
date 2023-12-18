package DataClasses

class Dog(val name: String,
          var weight_param: Int,
          val breed_param: String) {

    // It executes after constructor
    init {
        print("Dog $name has been created. ")
    }

    var activities = arrayOf("Walks")
    val breed = breed_param.toUpperCase()

    // It executes after variables declaration
    init {
        println("The breed is $breed.")
    }

    // First, it is assigned with weight_param value
    var weight = weight_param
        // When we try to change its value(weight) set method for this value is called
    set(value) {
        // We can control if weight update its value
        if (value > 0) field = value
    }

    val weightInKgs: Double
    // This get is for weightInKgs, and it is called, besides it can contain instructions
    get() = weight / 2.2

    fun bark() {
        println(if (weight > 19) "Woof!" else "Yiip")
    }
}