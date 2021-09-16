fun main(args: Array<String>) {
    //
    var x = 1
    println("Before the loop. x = $x.")
    while (x < 4) {
        println("In the loop. x = $x.")
        x = x + 1
    }
    println("After the loop. x = $x.")
    println("---")

    //
    x = 3
    val y = 1
    if (x > y )
        println("x is greater than y")
    else
        println("x is not greater than y")
    println("This line runs no matter what")
    println("---")

    //
    println(if (x > y) "x is greater than y" else "x is not greater than y")
}