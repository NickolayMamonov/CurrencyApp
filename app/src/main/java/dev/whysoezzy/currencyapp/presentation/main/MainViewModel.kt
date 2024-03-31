package dev.whysoezzy.currencyapp.presentation.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.currencyapp.domain.use_cases.GetLatestCurrenciesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getLatestCurrenciesUseCase: GetLatestCurrenciesUseCase,
    private val sharedPreferences: SharedPreferences

    ) : ViewModel() {
    private val _dataState = MutableStateFlow<MainScreenState>(MainScreenState.Loading)
    val dataState: StateFlow<MainScreenState> = _dataState

    private val _lastUpdateTime = MutableStateFlow(sharedPreferences.getLong("last_update_time", 0L))
    val lastUpdateTime: StateFlow<Long> = _lastUpdateTime

    init {
        loadDataAndUpdate()
    }

    private fun loadDataAndUpdate() {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                try {
                    val response = getLatestCurrenciesUseCase()
                    val currentTime = System.currentTimeMillis()
                    _dataState.emit(MainScreenState.Content(response))
                    updateLastUpdateTime(currentTime)
                } catch (th: Throwable) {
                    _dataState.emit(MainScreenState.Error(th))
                }
                delay(30000L)
            }
        }
    }

    private fun updateLastUpdateTime(currentTime: Long) {
        val currentTime = System.currentTimeMillis()
        sharedPreferences.edit().putLong("last_update_time", currentTime).apply()
        _lastUpdateTime.value = currentTime
    }


}