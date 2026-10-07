package org.umn.dheryl3470week07_a.data.local

import androidx.room.Dao
import androidx.room.*
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.umn.dheryl3470week07_a.model.Note

@Dao
interface NoteDao {
    @Query( value = "SELECT * FROM notes ORDER BY timestamp DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}