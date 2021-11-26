package com.example.cleanarchitecturenoteapp.feature_note.domain.model


import com.example.cleanarchitecturenoteapp.ui.theme.*

data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    val id: Int? = null
) {
    companion object {
        val noteColors = listOf(YellowOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)
