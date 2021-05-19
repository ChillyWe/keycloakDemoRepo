package com.example.kotlindemo.web

import com.example.kotlindemo.data.Message
import com.example.kotlindemo.service.MessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageResource(val service: MessageService) {

    @GetMapping("/message")
    fun index(): List<Message> = service.findMessages()

    @PostMapping("/message")
    fun post(@RequestBody message: Message) {
        service.post(message)
    }

}
