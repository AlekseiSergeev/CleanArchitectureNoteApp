package com.example.cleanarchitecturenoteapp.feature_note.data.mappers

import com.example.cleanarchitecturenoteapp.feature_note.data.model.NoteDbModel
import com.example.cleanarchitecturenoteapp.feature_note.domain.model.Note

class NoteDbMapper {

    fun toNoteDbModel (note: Note): NoteDbModel {
        return NoteDbModel(
            title = note.title,
            content = note.content,
            timestamp = note.timestamp,
            color = note.color,
            id = note.id
        )
    }

    fun toNote (noteDbModel: NoteDbModel): Note {
        return Note(
            title = noteDbModel.title,
            content = noteDbModel.content,
            timestamp = noteDbModel.timestamp,
            color = noteDbModel.color,
            id = noteDbModel.id
        )
    }
}