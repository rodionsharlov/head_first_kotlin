class Song(val title: String, val artist: String) {
    fun play() {
        println("Playing the song $title by $artist")
    }

    fun stop() {
        println("Stopped playing $title")
    }
}

class Dog(val name: String, var weight: Int, breed_param: String) {
    var activities = arrayOf("Walks")
    val breed = breed_param.toUpperCase()
    val weightInKgs: Double
        get() = weight / 2.2
}

fun main(args: Array<String>) {
    val songOne = Song("The Mesopotamians", "They Might Be Giants")
    val songTwo = Song ("Going Underground", "The Jam")
    val songThree = Song("Make Me Smile", "Steve Harley")

    songTwo.play()
    songTwo.stop()
    songThree.play()
}

