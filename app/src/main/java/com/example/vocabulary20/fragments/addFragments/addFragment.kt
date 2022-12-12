package com.example.vocabulary20.fragments.addFragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.vocabulary20.R
import com.example.vocabulary20.data.Vocab
import com.example.vocabulary20.viewModel.VocabViewModel

class addFragment : Fragment() {

    lateinit var vocabViewModel: VocabViewModel
    lateinit var addButton: Button
    lateinit var vocabText: EditText
    lateinit var definitionText: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        vocabViewModel = ViewModelProvider(this).get(VocabViewModel::class.java)

        vocabText = view.findViewById(R.id.vocabword)
        definitionText = view.findViewById(R.id.definition)
        addButton = view.findViewById(R.id.add_vocab)

        addButton.setOnClickListener{

            addVocabToDataBase()
        }

        return view
    }

    private fun addVocabToDataBase() {
        val word = vocabText.text.toString()
        val meaning = definitionText.text.toString()
        if (inputCheck(word, meaning)) {

            val vocab = Vocab(0, word, meaning)

            vocabViewModel.addVocab(vocab)

            Toast.makeText(requireContext(), "Adding", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(), "Invalid Input", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(word: String, meaning: String):Boolean{
        return !(TextUtils.isEmpty(word) && TextUtils.isEmpty(meaning))
    }

}