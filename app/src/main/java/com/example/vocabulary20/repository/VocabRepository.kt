package com.example.vocabulary20.repository

import androidx.lifecycle.LiveData
import com.example.vocabulary20.data.Vocab
import com.example.vocabulary20.data.VocabDao

class VocabRepository(private val vocabDao: VocabDao) {

    val readAllData : LiveData<List<Vocab>> = vocabDao.readVocab()

    suspend fun addVocab(vocab: Vocab){
        vocabDao.addVocab(vocab)
    }
}