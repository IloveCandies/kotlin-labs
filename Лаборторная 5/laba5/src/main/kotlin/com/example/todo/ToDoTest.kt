package com.example.todo
import org.junit.jupiter.api.Assertions.*

internal class ToDoTest {
    //ACTIVE у меня по умолчанию
    var toDo: ToDo = ToDo()
    @org.junit.jupiter.api.Test
    fun addItem() {
        val testItem =ToDoItem("Помыть посуду")
        toDo.addItem(testItem)
        toDo.addItem(ToDoItem("Погулять с собакой",Status.DONE))
        assertTrue(toDo.findItem("Помыть посуду")!! == testItem,"err_add")
    }

    @org.junit.jupiter.api.Test
    fun deleteItem() {
        val testItem =ToDoItem("Помыть посуду")
        toDo.addItem(testItem)
        toDo.deleteItem("Помыть посуду")
        assertTrue(toDo.findItem("Помыть посуду") == null,"err_del")
    }

    @org.junit.jupiter.api.Test
    fun deleteActiveItems() {
        toDo.addItem(ToDoItem("Помыть посуду"))
        toDo.deleteActiveItems()
        assertTrue(toDo.findItem("Помыть посуду") == null,"err_del_active")
    }

    @org.junit.jupiter.api.Test
    fun deleteDoneItems() {
        toDo.addItem(ToDoItem("Погулять с собакой",Status.DONE))
        toDo.deleteDoneItems()
        assertTrue(toDo.findItem("Погулять с собакой") == null,"err_del_done")
    }

    @org.junit.jupiter.api.Test
    fun deleteAllItems() {
        toDo.addItem(ToDoItem("Убраться"))
        toDo.addItem(ToDoItem("Погулять с собакой",Status.DONE))
        toDo.deleteAllItems()
        assertTrue(toDo.findItem("Погулять с собакой") == null,"err_del_all")
        assertTrue(toDo.findItem("Убраться") == null,"err")
    }

    @org.junit.jupiter.api.Test
    fun findItem() {
        val testItem =ToDoItem("Помыть посуду")
        toDo.addItem(testItem)
        assertTrue(toDo.findItem("Помыть посуду")!! == testItem,"err_find")
    }

    @org.junit.jupiter.api.Test
    fun changeItemStatus() {
        val testItem =ToDoItem("Помыть посуду")
        toDo.addItem(testItem)
        toDo.changeItemStatus("Помыть посуду",Status.DONE)
        assertTrue(toDo.findItem("Помыть посуду")!!.status.equals(Status.DONE),"err_change_st")
    }

    @org.junit.jupiter.api.Test
    fun changeItemDescription() {
        val testItem =ToDoItem("Помыть посуду")
        toDo.addItem(testItem)
        toDo.changeItemDescription("Помыть посуду","Протестировать",Status.ACTIVE)
        assertTrue(toDo.findItem("Протестировать")!!.description.equals("Протестировать"),"err_change_des")
    }

    @org.junit.jupiter.api.Test
    fun sortByStatus() {
        toDo.addItem(ToDoItem("Помыть посуду"))
        toDo.addItem(ToDoItem("Убраться"))
    }

    @org.junit.jupiter.api.Test
    fun addTag() {
        val testTag = Tag("дом")
        toDo.addTag(testTag)
        assertTrue(toDo.findTag("дом") == testTag,"err_add_tg")
    }

    @org.junit.jupiter.api.Test
    fun findTag() {
        val testTag = Tag("дом")
        toDo.addTag(testTag)
        assertTrue(toDo.findTag("дом") == testTag,"err_find_tg")
    }

    @org.junit.jupiter.api.Test
    fun deleteTag() {
        val testTag = Tag("дом")
        toDo.addTag(testTag)
        assertTrue(toDo.findTag("дом") == testTag,"err_add_tg")
        toDo.deleteTag("дом")
        assertFalse(toDo.findTag("дом") == testTag,"err_del_tg")
    }

    @org.junit.jupiter.api.Test
    fun addSubItem(){
        val item = ToDoItem("test")
        val subItem = "subitem"
        toDo.addItem(item)
        toDo.addSubItem("test",subItem)
        assertTrue(toDo.findItem("test")!!.subItemList.isNotEmpty())
    }
    @org.junit.jupiter.api.Test
    fun deleteSubItem(){
        val item = ToDoItem("test")
        val subItem = "subitem"
        toDo.addItem(item)
        toDo.addSubItem("test",subItem)
        assertTrue(toDo.findItem("test")!!.subItemList.contains(ToDoItem(subItem)))
        toDo.removeSubItem("test",subItem)
        assertTrue(toDo.findItem("test")!!.subItemList.isEmpty())
    }
    @org.junit.jupiter.api.Test
    fun addItemTag(){
        val item = ToDoItem("test")
        val tag = "tag"
        toDo.addItem(item)
        toDo.addItemTag("test",tag)
        assertTrue(toDo.findItem("test")!!.tagList.isNotEmpty())
    }
    @org.junit.jupiter.api.Test
    fun deleteItemTag(){
        val item = ToDoItem("test")
        val tag = "tag"
        toDo.addItem(item)
        toDo.addItemTag("test",tag)
        assertTrue(toDo.findItem("test")!!.tagList.contains(Tag(tag)))
        toDo.removeItemTag("test",tag)
        assertTrue(toDo.findItem("test")!!.tagList.isEmpty())
    }
    @org.junit.jupiter.api.Test
    fun addItemDocument(){
        val item = ToDoItem("test")
        val doc = "doc"
        toDo.addItem(item)
        toDo.addItemDocument("test",doc)
        assertTrue(toDo.findItem("test")!!.documentList.isNotEmpty())
    }
    @org.junit.jupiter.api.Test
    fun deleteItemDocument(){
        val item = ToDoItem("test")
        val doc = "doc"
        toDo.addItem(item)
        toDo.addItemDocument("test",doc)
        assertTrue(toDo.findItem("test")!!.documentList.contains(Document(doc)))
        toDo.removeItemDocument("test",doc)
        assertTrue(toDo.findItem("test")!!.documentList.isEmpty())
    }
}