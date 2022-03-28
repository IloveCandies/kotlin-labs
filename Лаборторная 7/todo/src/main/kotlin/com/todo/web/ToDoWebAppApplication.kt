package com.todo.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToDoWebAppApplication

fun main(args: Array<String>) {
	runApplication<ToDoWebAppApplication>(*args)
}
