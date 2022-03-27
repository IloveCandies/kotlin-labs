data class ToDoItem (var description: String = "default", var status:Status  = Status.ACTIVE) {}
enum class Status{
    ACTIVE,DONE
}