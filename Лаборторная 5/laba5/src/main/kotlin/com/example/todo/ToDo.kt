package com.example.todo
class ToDo (private val toDoList: MutableList<ToDoItem> = mutableListOf(), private val tagList: MutableList<Tag> = mutableListOf()){

    fun addItem(item: ToDoItem): Boolean = toDoList.add(item)

    fun deleteItem(description: String):Boolean=toDoList.removeIf { it.description.equals(description) }

    fun deleteActiveItems(): Boolean = toDoList.removeIf { it.status.equals(Status.ACTIVE) }

    fun deleteDoneItems(): Boolean = toDoList.removeIf { it.status.equals(Status.DONE) }

    fun deleteAllItems() = toDoList.clear()

    fun findItem(description: String): ToDoItem? = toDoList.find{it.description.equals(description)}

    fun changeItemStatus(description: String, newStatus: Status): Boolean {
        val item = findItem(description)
        if (item != null) {
            toDoList.set(toDoList.indexOf(item),ToDoItem(item.description,newStatus))
            return true
        }
        else
            return false
    }

    fun changeItemDescription(oldDescription: String, newDescription: String, newStatus: Status): Boolean {
        val item = findItem(oldDescription)
        if (item != null) {
            toDoList.set(toDoList.indexOf(item),ToDoItem(newDescription,newStatus))
            return true
        }
        else
            return false
    }

    fun sortByStatus(status: Status): List<ToDoItem> = when(status){
        Status.ACTIVE -> toDoList.filter {it.status.equals(Status.ACTIVE)}
        Status.DONE -> toDoList.filter {it.status.equals(Status.DONE)}
        else -> toDoList
    }

    fun printToConsole(){
        for (item in toDoList){
            println(item.toString())
        }
        for (tag in tagList){
            println(tag.toString())
        }
    }
    fun addTag(tag: Tag): Boolean = tagList.add(tag)

    fun findTag(tagName: String): Tag? = tagList.find{it.name.equals(tagName)}

    fun deleteTag(tagName: String):Boolean {
        val tag = findTag(tagName)
        if (tag != null){
            tagList.remove(tag)
            return true
        }
        else  return false
    }
    //Вопрос, а как лучше реализовывать добавление - получать строку и создавать новый элемент,
    // или срезу передавать элемент ToDoItem, а реализацию отдавать на ToDoApplication?
    fun addSubItem(itemDescription: String, subItemDescription: String) : Boolean {
        val item  = findItem(itemDescription)
        val subItem = ToDoItem(subItemDescription)
        if (item != null){
            item.subItemList.add(subItem)
            return true
        }
        else return false
    }

    fun addItemTag(itemName: String, tagDescription: String) : Boolean {
        val item  = findItem(itemName)
        val tag = Tag(tagDescription)
        if (item != null){
            item.tagList.add(tag)
            return true
        }
        else return false
    }

    fun addItemDocument(itemName: String, documentTitle: String ) : Boolean {
        val item  = findItem(itemName)
        val doc = Document(documentTitle)
        if (item != null){
            item.documentList.add(doc)
            return true
        }
        else return false
    }

    fun removeSubItem(itemDescription: String, subItemDescription: String) : Boolean {
        val item  = findItem(itemDescription)
        val subItem = ToDoItem(subItemDescription)
        if (item != null){
            item.subItemList.remove(subItem)
            return true
        }
        else return false
    }

    fun removeItemTag(itemName: String, tagDescription: String) : Boolean {
        val item  = findItem(itemName)
        val tag = Tag(tagDescription)
        if (item != null){
            item.tagList.remove(tag)
            return true
        }
        else return false
    }

    fun removeItemDocument(itemName: String, documentTitle: String  ) : Boolean {
        val item  = findItem(itemName)
        val doc = Document(documentTitle)
        if (item != null){
            item.documentList.remove(doc)
            return true
        }
        else return false
    }
}