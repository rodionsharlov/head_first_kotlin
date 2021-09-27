import java.io.File
import javax.sound.sampled.AudioSystem
import kotlinx.coroutines.*

suspend fun playBeats(beats: String, file: String) {
    val parts = beats.split("x")
    var count = 0
    for (part in parts) {
        count += part.length + 1
        if (part == "") {
            playSound(file)
        } else {
            /*Thread.sleep*/delay(250 * (part.length + 1L))
            if (count < beats.length) {
                playSound(file)
            }
        }
    }
}

fun playSound(file: String) {
    val clip = AudioSystem.getClip()
    val audioInputStream = AudioSystem.getAudioInputStream(File(file))
    clip.open(audioInputStream)
    clip.start()
}

suspend fun main() {

    /* 1st version, non-parallel */
    /*
    playBeats("x-----x-----", "Audio/crash_cymbal.wav") }
    playBeats("x-x-x-x-x-x-", "Audio/toms.wav")
    */

    /* 2nd version, parallel */
    /*
    GlobalScope.launch{ playBeats("x-----x-----", "Audio/crash_cymbal.wav") }
    playBeats("x-x-x-x-x-x-", "Audio/toms.wav")
    */

    /* 3rd version, parallel, the most efficient */
    runBlocking {
        launch{ playBeats("x-----x-----", "Audio/crash_cymbal.wav") }
        playBeats("x-x-x-x-x-x-", "Audio/toms.wav")
    }

}