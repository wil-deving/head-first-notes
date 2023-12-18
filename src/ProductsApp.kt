fun main(args: Array<String>) {
    checkProduct()
}

fun checkProduct() {
    var exit = false
    while (!exit) {
        println("Please in product name to search or write exit to end")
        val inputProduct = readLine()!!.toString()
        if (inputProduct.toLowerCase() == "exit") {
            exit = true
            continue
        } else {
            val foundProduct = findProduct(inputProduct)
            if (foundProduct == null) {
                println("Product was not found, try again")
                continue
            }
            val result = getSalePricesByProduct(foundProduct)
            println("Product: ${result.name}")
            println("Price: ${result.salePrice}")
            println("Stock ${result.stock}")
        }
    }
    println("Ending program...")
}

fun fillProducts() : Array<Product>{
    return arrayOf(
            Product("P-1", "Televisor", "Tecnologia", 20, 100.00, null),
            Product("P-2", "Radio", "Tecnologia", 10, 78.00, null),
            Product("P-3", "Computadora", "Tecnologia", 8, 3400.00, null),
            Product("P-4", "Lavadora", "Linea blanca", 17, 4200.00, null),
            Product("P-5", "Micro ondas", "Linea blanca", 34, 580.00, null),
            Product("P-6", "Cuaderno", "Varios", 89, 10.00, null),
            Product("P-7", "Lapiz", "Varios", 99, 2.00, null)
    )
}

fun findProduct(productNameToSearch: String) : Product? {
    val allProducts = fillProducts()
    for (product in allProducts) {
        if (product.name.equals(productNameToSearch, ignoreCase = true)) return product
    }
    return null
}

fun getSalePricesByProduct(product: Product) : Product {
    when (product.category) {
        "Tecnologia" -> product.salePrice = product.price - (product.price * 0.05)
        "Linea blanca" -> product.salePrice = product.price - (product.price * 0.1)
        else -> product.salePrice = product.price
    }
    return product
}

class Product(
        val id: String,
        val name: String,
        val category: String,
        val stock: Int,
        val price: Double,
        var salePrice: Double?
)