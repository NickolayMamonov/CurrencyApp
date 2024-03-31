package dev.whysoezzy.currencyapp.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dev.whysoezzy.currencyapp.R
import dev.whysoezzy.currencyapp.databinding.FragmentMainBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainFragment : Fragment() {
    private val vm by viewModel<MainViewModel>()
    private lateinit var binding: FragmentMainBinding
    private lateinit var mainAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val error = binding.errorText
        val progressBar = binding.progressBar
        val timestamp = binding.lastUpd
        val recyclerView = binding.recycleView

        vm.dataState.onEach { datastate ->
            when (datastate) {
                is MainScreenState.Content -> {
                    error.visibility = View.INVISIBLE
                    progressBar.visibility = View.INVISIBLE
                    mainAdapter = MainAdapter(datastate.valutes)
                    recyclerView.layoutManager = LinearLayoutManager(requireContext())
                    recyclerView.adapter = mainAdapter

                }

                is MainScreenState.Error -> {
                    error.visibility = View.VISIBLE
                    progressBar.visibility = View.INVISIBLE
                }

                is MainScreenState.Loading -> {
                    error.visibility = View.INVISIBLE
                    progressBar.visibility = View.VISIBLE
                }
            }
        }.launchIn(lifecycleScope)
        vm.lastUpdateTime.onEach { lastUpdateTime ->
            val dateTimeString = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(
                Date(lastUpdateTime)
            )
            timestamp.text = "Последнее обновление: $dateTimeString"
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        return binding.root
    }

}