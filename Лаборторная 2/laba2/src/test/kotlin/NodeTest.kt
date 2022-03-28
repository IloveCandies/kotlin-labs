
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class NodeTest{
   @Test
    fun main(){
        var three = NodeThree()
        three.add(value = 6)
        three.add(value = 4)
        three.add(value = 3)
        three.add(value = 7)
        three.add(value = 8)
        three.add(value = 9)
        three.add(value = 10)
        three.add(value = 11)
        // back into object
        val obj = Json.encodeToJsonElement(three.check(value = 8))
        println(obj)
        assertTrue(three.check(value = 8),"err")
        three.preOrderWalk(three.rootNode)
    }
}