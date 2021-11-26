package com.example.cleanarchitecturenoteapp.feature_note.data.data_sourse.db

import androidx.room.*
import com.example.cleanarchitecturenoteapp.feature_note.data.model.NoteDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<NoteDbModel>>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun geyNoteById(id: Int): NoteDbModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteDbModel)

    @Delete
    suspend fun deleteNote(note: NoteDbModel)
}