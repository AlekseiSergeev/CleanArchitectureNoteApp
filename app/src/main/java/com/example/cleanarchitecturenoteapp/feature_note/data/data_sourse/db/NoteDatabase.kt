package com.example.cleanarchitecturenoteapp.feature_note.data.data_sourse.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecturenoteapp.feature_note.data.model.NoteDbModel

@Database(
    entities = [NoteDbModel::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}