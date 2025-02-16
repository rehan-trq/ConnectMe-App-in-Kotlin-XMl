package com.RehanTariq.i220965

data class ChatMessage(
    val text: String,
    val timestamp: String,
    val isIncoming: Boolean  // true if message is from "Henry Benjamin," false if from the user
)
