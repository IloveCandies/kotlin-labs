package com.example.todo

import ToDoItem
import org.junit.jupiter.api.Assertions.*

internal class ToDoTest {
    //ACTIVE у меня по умолчанию
    var toDo: ToDo = ToDo()
    @org.junit.jupiter.api.Test
    fun addItem() {
        toDo.addItem(ToDoItem("Помыть посуду"))
        toDo.addItem(ToDoItem("Убраться"))
        toDo.addItem(ToDoItem("Погулять с собакой",Status.DONE))
        toDo.addItem(ToDoItem("Отдохнуть"))

    }

    @org.junit.jupiter.api.Test
    fun deleteItem() {
        toDo.addItem(ToDoItem("Помыть посуду"))
        toDo.addItem(ToDoItem("Убраться"))
    }

    @org.junit.jupiter.api.Test
    fun deleteActiveItems() {
        toDo.addItem(ToDoItem("Помыть посуду"))
        toDo.addItem(ToDoItem("Убраться"))
    }

    @org.junit.jupiter.api.Test
    fun deleteDoneItems() {
        toDo.deleteDoneItems()
    }

    @org.junit.jupiter.api.Test
    fun deleteAllItems() {
        toDo.addItem(ToDoItem("Помыть посуду"))
        toDo.addItem(ToDoItem("Убраться"))
    }

    @org.junit.jupiter.api.Test
    fun findItem() {
        toDo.addItem(ToDoItem("Помыть посуду"))
        toDo.addItem(ToDoItem("Убраться"))
    }

    @org.junit.jupiter.api.Test
    fun changeItemStatus() {
        toDo.addItem(ToDoItem("Помыть посуду"))
        toDo.addItem(ToDoItem("Убраться"))
    }

    @org.junit.jupiter.api.Test
    fun changeItemDescription() {
        toDo.addItem(ToDoItem("Помыть посуду"))
        toDo.addItem(ToDoItem("Убраться"))
    }

    @org.junit.jupiter.api.Test
    fun sortByStatus() {
        toDo.addItem(ToDoItem("Помыть посуду"))
        toDo.addItem(ToDoItem("Убраться"))
    }

    @org.junit.jupiter.api.Test
    fun addTag() {
        toDo.addTag(Tag("дом"))
        toDo.addTag(Tag("работа","Red"))
    }

    @org.junit.jupiter.api.Test
    fun findTag() {
        toDo.addItem(ToDoItem("Помыть посуду"))
        toDo.addItem(ToDoItem("Убраться"))
    }

    @org.junit.jupiter.api.Test
    fun deleteTag() {
        toDo.addItem(ToDoItem("Помыть посуду"))
        toDo.addItem(ToDoItem("Убраться"))
    }
}