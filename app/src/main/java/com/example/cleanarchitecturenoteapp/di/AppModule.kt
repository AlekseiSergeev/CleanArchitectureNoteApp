package com.example.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.example.cleanarchitecturenoteapp.feature_note.data.data_sourse.db.NoteDatabase
import com.example.cleanarchitecturenoteapp.feature_note.data.mappers.NoteDbMapper
import com.example.cleanarchitecturenoteapp.feature_note.data.repository.NoteLocalDataSource
import com.example.cleanarchitecturenoteapp.feature_note.data.repository.NoteLocalDataSourceImpl
import com.example.cleanarchitecturenoteapp.feature_note.data.repository.NoteRepositoryImpl
import com.example.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.example.cleanarchitecturenoteapp.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDbMapper(): NoteDbMapper {
        return NoteDbMapper()
    }

    @Provides
    @Singleton
    fun provideNoteLocalDataSource(db: NoteDatabase, mapper: NoteDbMapper): NoteLocalDataSource {
        return NoteLocalDataSourceImpl(db.noteDao, mapper)
    }

    @Provides
    @Singleton
    fun provideNoteRepository(dataSource: NoteLocalDataSource): NoteRepository {
        return NoteRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository),
            addNote = AddNoteUseCase(repository),
            getNote = GetNoteUseCase(repository)
        )
    }
}