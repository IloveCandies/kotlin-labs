package com.todo.web

import kotlinx.serialization.*
import kotlinx.serialization.json.Json.Default.encodeToJsonElement
import kotlinx.serialization.json.JsonElement
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

private val logger: Logger = LoggerFactory.getLogger(MainController::class.java)

@Serializable
data class Project(val name: String, val language: String)

@RestController
class  MainController{
    var toDoList: ToDo = ToDo()

    @RequestMapping("/create/{name}",method = [RequestMethod.POST])
    fun create(@PathVariable("name") name:String): JsonElement {
        toDoList = ToDo(name)
        return encodeToJsonElement(serializer(),toDoList)
    }

    @RequestMapping("/create/{todo}/{name}",method = [RequestMethod.POST])
    fun createItem(@PathVariable("todo") todo:String,@PathVariable("name") name:String): JsonElement? {
        if (toDoList.getName() == (todo)) {
            toDoList.addItem(ToDoItem(name,Status.ACTIVE))
            println( toDoList.returnItems()+" !create")
            return encodeToJsonElement(serializer(), toDoList)
        }
        else {
            return null
        }
    }
    @RequestMapping("/find/{todo}/{name}",method = [RequestMethod.GET])
    fun findItem(@PathVariable("todo") todo:String,@PathVariable("name") name:String): JsonElement? {
        if(toDoList.getName() == (todo)) {
            println(toDoList.findItem(name).toString()+" !find")
            return encodeToJsonElement(serializer(),toDoList.findItem(name))
        }
        else {
            return null
        }
    }
    //поиск todoItem
    @RequestMapping("/show/{todo}/",method = [RequestMethod.GET])
    fun showAll(@PathVariable("todo") todo:String): JsonElement? {
        if (toDoList.getName() == (todo)) {
            println(toDoList)
            return encodeToJsonElement(serializer(),toDoList)
        }
        else {
            return null
        }
    }
    @RequestMapping("/delete/{todo}/{name}",method = [RequestMethod.DELETE])
    fun removeItem(@PathVariable("todo") todo:String,@PathVariable("name") name:String): JsonElement? {
        if (toDoList.getName() == (todo)) {
            toDoList.deleteItem(name)
            println( toDoList.returnItems()+" !create")
            return encodeToJsonElement(serializer(),toDoList)
        }
        else {
            return null
        }
    }
}