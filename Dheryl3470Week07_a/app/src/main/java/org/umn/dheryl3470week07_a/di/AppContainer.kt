package org.umn.dheryl3470week07_a.di

import android.content.Context
import org.umn.dheryl3470week07_a.data.local.NoteDatabase
import org.umn.dheryl3470week07_a.data.repository.NoteRepository

class AppContainer(context: Context) {
    private val database: NoteDatabase by lazy {
        NoteDatabase.getDatabase(context)
    }

    val noteRepository: NoteRepository by lazy {
        NoteRepository(noteDao = database.noteDao())
    }
}