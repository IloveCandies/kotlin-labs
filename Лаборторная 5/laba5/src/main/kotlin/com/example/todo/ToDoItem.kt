package com.example.todo

data class ToDoItem (
    var description: String = "default",
    var status:Status  = Status.ACTIVE,
    var subItemList: MutableList<ToDoItem> = mutableListOf(),
    var documentList: MutableList<Document> = mutableListOf(),
    var tagList: MutableList<Tag> = mutableListOf(),
) {}

enum class Status {
    ACTIVE,DONE
}
