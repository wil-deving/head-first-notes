package Fundaments

fun main(args: Array<String>) {
    println("Pow con Kotlin!!!!")
    val options = arrayOf("Rock", "Paper", "Scissors")
    var gameChoice = getGameChoice(options)
    var userChoice = getUserChoice(options)
    showResult(gameChoice, userChoice)
}

fun getGameChoice(opt: Array<String>) = opt[(Math.random() * opt.size).toInt()]

fun getUserChoice(opt: Array<String>): String {
    var isValidateChoice = false
    var userChoice = ""
    while (!isValidateChoice) {
        print("Please, enter one of the following:")
        for (item in opt) print(" $item")
        println(".")
        // User input
        val userInput = readLine()
        if (userInput != null && userInput in opt) {
            isValidateChoice = true
            userChoice = userInput
        }
        if (!isValidateChoice) println("Chose a correct option")
    }
    return userChoice
}

fun showResult(gameChoice: String, userChoice: String): Unit {
    val result: String
    if (gameChoice == userChoice) result = "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
            (userChoice == "Paper" && gameChoice == "Rock") ||
            (userChoice == "Scissors" && gameChoice == "Paper")) result = "You win!"
    else result = "You lose!"
    println("You Chose $userChoice. I Chose $gameChoice. $result")
}