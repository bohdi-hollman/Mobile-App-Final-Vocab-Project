package com.example.vocabulary20.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.vocabulary20.data.Vocab
import com.example.vocabulary20.data.VocabDatabase
import com.example.vocabulary20.repository.VocabRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VocabViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllData: LiveData<List<Vocab>>

    private val repository : VocabRepository

    init {
        val vocabDao = VocabDatabase.getInstance(application).VocabDao()
        repository = VocabRepository(vocabDao)
        readAllData = repository.readAllData
    }

    fun addVocab(vocab: Vocab){

        viewModelScope.launch (Dispatchers.IO){
            repository.addVocab(vocab)
        }
    }
}