package com.example.vocabulary20.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VocabDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVocab(vocab: Vocab)
    
    @Query("Select * from vocab_table Order BY id ASC")
    fun readVocab() : LiveData<List<Vocab>>
}