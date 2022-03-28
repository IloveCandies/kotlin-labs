package com.todo.web

import kotlinx.serialization.Serializable

@Serializable
class ToDoTagItem (var name: String, var color: String = "Black") {
    fun changeColor(newColor: String) {
        this.color = newColor
    }
    fun changeName(newName: String){
        this.name = newName
    }
}