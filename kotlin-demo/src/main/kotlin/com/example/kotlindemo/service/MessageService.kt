package com.example.kotlindemo.service

import com.example.kotlindemo.data.Message
import com.example.kotlindemo.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(val db: MessageRepository) {

    fun findMessages(): List<Message> = db.findMessages()

    fun post(message: Message){
        db.save(message)
    }

}
