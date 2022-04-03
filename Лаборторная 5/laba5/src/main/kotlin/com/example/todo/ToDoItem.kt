package com.example.todo

data class ToDoItem (
    var description: String = "default",
    var status:Status  = Status.ACTIVE,
    var subItem: MutableList<ToDoItem> = mutableListOf(),
    var document: MutableList<Document> = mutableListOf(),
    var tag: MutableList<Tag> = mutableListOf(),
) {}

enum class Status {
    ACTIVE,DONE
}
data class Document(var title:String = "default", var url: String = "https://www.default.com"){}