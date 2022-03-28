import kotlinx.serialization.Serializable

@Serializable
class Node(var value: Int = 0) {
    var left: Node? = null
    var right: Node? = null
}

@Serializable
class NodeThree(){
    var rootNode:Node?  = null
    private fun addNode( currentNode: Node? = null, value:Int = 0): Node {
        if(currentNode == null) {
            return Node(value)
        }
        when {
            value  < currentNode.value -> currentNode.left = addNode(currentNode.left,value)
            value  > currentNode.value -> currentNode.right = addNode(currentNode.right,value)
            else -> return currentNode
        }
        return currentNode
    }

    private fun checkContains(currentNode: Node? = null, value:Int = 0): Boolean {

        if(currentNode == null) {
            return false
        }
        else if(value == currentNode.value){
            return true
        }

        return ( when {
            value  < currentNode.value -> checkContains(currentNode.left,value)
            value  > currentNode.value -> checkContains(currentNode.right,value)
            else -> true
        })
    }

    fun preOrderWalk(startNode: Node?) {
        val walk = mutableListOf<Int>()
        if(startNode != null) {
            walk.add(startNode.value.toInt())
            print(" $walk")
            preOrderWalk(startNode.left)
            preOrderWalk(startNode.right)
        }
    }
    fun check(value: Int): Boolean {
        return checkContains(rootNode,value)
    }

    fun add(value: Int){
        rootNode = addNode(rootNode,value)
    }
}

