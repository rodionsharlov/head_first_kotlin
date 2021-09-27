data class Grocery(val name: String, val category: String,
                   val unit: String, val unitPrice: Double,
                   val quantity: Int)

fun main(args: Array<String>) {
    val groceries = listOf(Grocery("Tomatoes","Vegetable","lb",3.0,3),
        Grocery("Mushrooms","Vegetable","lb",4.0,1),
        Grocery("Bagels","Bakery","Pack",1.5,2),
        Grocery("Olive oil","Pantry","Bottle",6.0,1),
        Grocery("Ice cream","Frozen","Pack",3.0,2))

//    val highestUnitPrice = groceries.maxByOrNull {it.unitPrice * 5 }
//    println("highestUnitPrice: $highestUnitPrice")
//    val lowestQuantity = groceries.minByOrNull {it.quantity }
//    println("lowestQuantity: $lowestQuantity")
//
//    val sumQuantity = groceries.sumBy {it.quantity}
//    println("sumQuantity: $sumQuantity")
//    val totalPrice = groceries.sumByDouble { it.quantity * it.unitPrice }
//    println("totalPrice: $totalPrice")

//    val vegetables = groceries.filter { it.category == "Vegetable" }
//    println("vegetables: $vegetables")
//    val notFrozen = groceries.filterNot { it.category == "Frozen" }
//    println("notFrozen: $notFrozen")
//
//    val groceryNames = groceries.map { it.name }
//    println("groceryNames: $groceryNames")
//    val halfUnitPrice = groceries.map { it.unitPrice * 0.5 }
//    println("halfUnitPrice: $halfUnitPrice")
//
//    val newPrices = groceries.filter {it.unitPrice > 3.0}
//        .map {it.unitPrice * 2}
//    println("newPrices: $newPrices")
//
//    println("Grocery names: ")
//    groceries.forEach {println(it.name) }
//
//    println("Groceries with unitPrice > 3.0: ")
//    groceries.filter {it.unitPrice > 3.0 }
//        .forEach {println(it.name)}
//
//    var itemNames = ""
//    groceries.forEach({ itemNames += "${it.name} "})
//    println("itemNames: $itemNames")

    groceries.groupBy { it.category }.forEach{
        println(it.key)
        it.value.forEach{ println("   ${it.name}") }
    }

    val ints = listOf(1, 2, 3)
//    val sumOfInts = ints.fold(0) {runningSum, item -> runningSum + item }
    val sumOfInts: Int = ints.reduce { runningSum, item -> runningSum + item }
    /* Reduce uses the first item's value as a starting value by default (unlike Fold)*/
    println("sumOfInts: $sumOfInts")

    val productOfInts = ints.fold(1) {runningProduct, item -> runningProduct * item }
    println("productOfInts: $productOfInts")

    val names = groceries.fold("") {string, item -> string + " ${item.name}" }
    println("names: $names")

    val changeFrom50 = groceries.fold(50.0) {change, item ->
        change - item.unitPrice * item.quantity }
    println("changeFrom50: $changeFrom50")


}

// The following is just another exercise
/*
abstract class Pet(var name: String)

class Cat(name: String) : Pet(name)

class Dog(name: String) : Pet(name)

class Fish(name: String) : Pet(name)

class Contest<T: Pet>() {
    var scores: MutableMap<T, Int> = mutableMapOf()

    fun addScore(t: T, score: Int = 0) {
        if (score >= 0) scores.put(t, score)
    }

    fun getWinners(): Set<T> {
        val highScore = scores.values.maxOrNull()
        val winners = scores.filter{ it.value == highScore }.keys
        winners.forEach{ println("Winner: ${it.name}") }
        return winners
    }
}

fun main() {
    val cat = Cat("Cat")
    val dog = Dog("Dog")
    val fish = Fish("Fish")

    val contest = Contest<Pet>()
    contest.addScore(cat, 1)
    contest.addScore(dog, 2)
    contest.addScore(fish, 3)

    contest.getWinners()

}
*/

////////////////

/*
data class Grocery(val name: String, val category: String,

                   val unit: String, val unitPrice: Double,

                   val quantity: Int)



fun main() {
	val groceries = listOf(Grocery("Tomatoes", "Vegetable", "lb", 3.0, 3),

                       Grocery("Mushrooms", "Vegetable", "lb", 4.0, 1),

                       Grocery("Bagels", "Bakery", "Pack", 1.5, 2),

                       Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),

                       Grocery("Ice cream", "Frozen", "Pack", 3.0, 2))

//     val veggySum: Double = groceries.filter{it.category == "Vegetable"}
//     	.map{it.quantity * it.unitPrice}
//         .reduce{sum, item -> sum + item}

//     val veggySum: Double = groceries.filter{it.category == "Vegetable"}
//         .fold(0.0) {sum, item -> sum + (item.quantity * item.unitPrice)}
    //
    val veggySum = groceries.filter{it.category == "Vegetable"}
        .fold(0.0) {sum, item -> sum + (item.quantity * item.unitPrice)}

    println(veggySum)
    //
	val lessNames = groceries.filter{ (it.quantity * it.unitPrice) < 5.0 }
        .map {it.name}

    println(lessNames)
    //
    groceries.groupBy{ it.category }.forEach {
        print("${it.key}: ")
        println(it.value.fold(0.0) {sum, item -> sum + (item.quantity * item.unitPrice)})
    }
    //
    println("")
    groceries.filterNot {it.unit == "Bottle"}.groupBy{ it.unit }.forEach{
        println("${it.key}:")
        it.value.forEach{ println("   ${it.name}") }
    }

}
 */