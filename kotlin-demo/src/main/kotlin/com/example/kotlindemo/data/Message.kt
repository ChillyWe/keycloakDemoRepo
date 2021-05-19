package com.example.kotlindemo.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("MESSAGE")
data class Message(@Id val id: String?, val text: String)
