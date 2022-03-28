package com.todo.web

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.*
import kotlinx.serialization.json.Json.Default.encodeToJsonElement
import kotlinx.serialization.json.JsonElement

@Serializable
data class Project(val name: String, val language: String)

@RestController
class  MainController{
    @RequestMapping("/home",method=[RequestMethod.GET])
    fun home(): String? {
        return "HOME"
    }

    @RequestMapping("/create/todo/{name}?",method = [RequestMethod.POST,RequestMethod.GET])
    fun create(@PathVariable("name") name:String): JsonElement {
        val toDoList: ToDo = ToDo(name)
        toDoList.addItem(ToDoItem("TestPost",Status.ACTIVE))
        return encodeToJsonElement(serializer(),toDoList)
    }
    @RequestMapping("/create/{todo}/{name}",method = [RequestMethod.POST,RequestMethod.GET])
    fun createItem(@PathVariable("todo") todo:String,@PathVariable("name") name:String): JsonElement {
        val toDoList: ToDo = ToDo(todo)
        toDoList.addItem(ToDoItem(name,Status.ACTIVE))
        return encodeToJsonElement(serializer(),toDoList)
    }

}