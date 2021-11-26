package com.example.cleanarchitecturenoteapp.feature_note.data.repository

import com.example.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteLocalDataSource {
    fun getNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
}