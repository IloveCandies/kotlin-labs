import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    val ctx: ApplicationContext = AnnotationConfigApplicationContext(ToDoConfig::class.java)
    var toDo: ToDo = ctx.getBean(ToDo::class.java)
    //ACTIVE у меня по умолчанию
    toDo.addItem(ToDoItem("Помыть посуду"))
    toDo.addItem(ToDoItem("Убраться"))
    toDo.addItem(ToDoItem("Погулять с собакой",Status.DONE))
    toDo.addItem(ToDoItem("Отдохнуть"))
    toDo.addTag(Tag("дом"))
    toDo.addTag(Tag("работа","Red"))
    toDo.printToConsole()
    toDo.deleteDoneItems()
    println("После удаления")
    toDo.printToConsole()

    while(true){
        println("Введите команду из списка: addItem,addTag,deleteItem,deleteTag,printToConsole,exit")
        when(readLine()!!.toString()){
            "addItem" -> {
                println("Введите описание")
                toDo.addItem(ToDoItem(readLine()!!.toString()))
            }
            "addTag" -> {
                println("Введите описание")
                toDo.addTag(Tag(readLine()!!.toString()))
            }
            "printToConsole" -> {
                toDo.printToConsole()
            }
            "exit" -> {
                break
            }
            else -> continue
        }
    }

}