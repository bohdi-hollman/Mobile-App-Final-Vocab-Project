package com.example.vocabulary20.fragments.listFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.vocabulary20.R
import com.example.vocabulary20.adapter.ListAdapter
import com.example.vocabulary20.adapter.VocabClickListener
import com.example.vocabulary20.data.Vocab
import com.example.vocabulary20.viewModel.VocabViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment(), VocabClickListener {

    lateinit var floatingActionButton: FloatingActionButton
    lateinit var vocabViewModel: VocabViewModel
    lateinit var vocabRecyclerView: RecyclerView
    lateinit var vocabList: List<Vocab>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)


        vocabRecyclerView = view.findViewById(R.id.recycler)
        vocabList = ArrayList<Vocab>()
        val adapter = ListAdapter(vocabList)
        vocabRecyclerView.adapter = adapter


        vocabViewModel = ViewModelProvider(this).get(VocabViewModel::class.java)
        vocabViewModel.readAllData.observe(viewLifecycleOwner, Observer { vocab ->
            val adapter = ListAdapter(vocab, this)
            vocabRecyclerView.adapter = adapter
        })

        floatingActionButton = view.findViewById(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }

    override fun clickListener(position: Int) {
        Toast.makeText(requireContext(), "Clicked ${position}", Toast.LENGTH_LONG).show()
    }

}