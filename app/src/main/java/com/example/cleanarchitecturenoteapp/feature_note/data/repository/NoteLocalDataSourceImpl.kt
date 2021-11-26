package com.example.cleanarchitecturenoteapp.feature_note.data.repository

import com.example.cleanarchitecturenoteapp.feature_note.data.data_sourse.db.NoteDao
import com.example.cleanarchitecturenoteapp.feature_note.data.mappers.NoteDbMapper
import com.example.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteLocalDataSourceImpl(
    private val dao: NoteDao,
    private val mapper: NoteDbMapper
): NoteLocalDataSource {

    override fun getNotes(): Flow<List<Note>> {
        val notesFlow = dao.getNotes()
        return notesFlow.map { list ->
            list.map { element ->
                mapper.toNote(element)
            }
        }
    }

    override suspend fun getNoteById(id: Int): Note? {
        val note = dao.geyNoteById(id)
        return let { note }?.let { mapper.toNote(it) }
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(mapper.toNoteDbModel(note))
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(mapper.toNoteDbModel(note))
    }
}