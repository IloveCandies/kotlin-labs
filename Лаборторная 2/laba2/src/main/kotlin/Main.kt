import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

class Main {
    fun main() {
        var three = NodeThree()
        three.add(value = 6)
        three.add(value = 4)
        three.add(value = 3)
        three.add(value = 7)
        three.add(value = 8)

        val obj = Json.encodeToJsonElement(three.check(value = 8))
        print(obj)
        three.preOrderWalk(three.rootNode)
    }
}