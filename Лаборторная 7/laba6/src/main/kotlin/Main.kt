import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.net.HttpURLConnection
import java.net.URL

@Serializable
data class Video(
    val id: String = "null",
    val title: String = "null",
    val speaker: String  = "null",
    val videoUrl: String  = "null"
)

//данные для обучения от jetbrains
fun getVideo(id: Int): Video {
    var obj: Video = Video()
    try {
        val url: URL =  URL ("https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/videos/$id")
        val con: HttpURLConnection = url.openConnection() as HttpURLConnection
        con.connectTimeout = 5000
        con.readTimeout = 5000

        //инфо
        println(con)
        println(con.responseCode)
        println(con.responseMessage)

        val reader = con.inputStream.reader()
        var json = reader.readLines()
        reader.close()
        con.disconnect()
        var data = mutableListOf<String>()

        //decodeToJson не хотел работать изза специфичного ответа поэтому жестко и костыльно пришлось
        for (i in 1..5 ){
            var str = json[i].split(":")
            if(str.size == 2){
                data.add(str[1])
            }
            else if(str.size==3){
                data.add(str[1]+str[2])
            }
        }
        obj = Video(data[0],data[2],data[3],data[1])
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return obj
}


fun main(){
    var playlist:MutableList<Video> =  mutableListOf<Video>()
    var video = getVideo(1)
    println(video)
    playlist.add(video)
}