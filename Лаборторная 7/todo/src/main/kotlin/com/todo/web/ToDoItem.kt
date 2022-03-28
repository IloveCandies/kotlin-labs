package com.todo.web

import kotlinx.serialization.Serializable

@Serializable
data class ToDoItem (var description: String = "default", var status:Status  = Status.ACTIVE) {}
enum class Status{
    ACTIVE,DONE
}