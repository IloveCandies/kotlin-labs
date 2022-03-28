import org.junit.jupiter.api.Assertions.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @org.junit.jupiter.api.Test
    fun getVideo() {
        var video = getVideo(1)
        assertTrue(video.videoUrl == "https//www.youtube.com/watch?v=PsaFVLr8t4E","err")
    }

    @org.junit.jupiter.api.Test
    fun main() {
        var playlist:MutableList<Video> =  mutableListOf<Video>()
        var video = getVideo(1)
        println(video)
        playlist.add(video)
        assertTrue(playlist.size == 1,"err")
    }
}