package com.example.cleanarchitecturenoteapp.feature_note.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteDbModel(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey
    val id: Int? = null
)