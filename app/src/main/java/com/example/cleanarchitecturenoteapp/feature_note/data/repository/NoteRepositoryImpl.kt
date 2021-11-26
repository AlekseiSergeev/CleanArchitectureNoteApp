package com.example.cleanarchitecturenoteapp.feature_note.data.repository

import com.example.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.example.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
   private val dataSource: NoteLocalDataSource
): NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dataSource.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dataSource.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return dataSource.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dataSource.deleteNote(note)
    }
}