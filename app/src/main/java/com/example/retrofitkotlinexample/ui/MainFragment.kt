package com.example.retrofitkotlinexample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitkotlinexample.databinding.FragmentMainBinding
import com.example.retrofitkotlinexample.model.CommentModel
import com.example.retrofitkotlinexample.ui.adapter.RecyclerViewAdapter

class MainFragment : Fragment() {
   private lateinit var binding: FragmentMainBinding
   private lateinit var mainViewModel: MainViewModel
   private lateinit var commentList: CommentModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.getDataFromServer()
        mainViewModel.getItemList().observe(viewLifecycleOwner) {
            commentList = it
            binding.recyclerView.adapter = RecyclerViewAdapter(commentList)
        }
    }

}