package com.example.retrofitkotlinexample.model

data class CommentModelItem(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)