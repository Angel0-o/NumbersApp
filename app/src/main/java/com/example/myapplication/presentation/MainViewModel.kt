package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecases.number.AddNumberUseCase
import com.example.myapplication.domain.usecases.number.GetNumberByOrderRepetitionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addNumberUseCase: AddNumberUseCase,
    private val getNumberByOrderRepetitionUseCase: GetNumberByOrderRepetitionUseCase
) : ViewModel() {

    private val mNumbersByOrder = MutableStateFlow("")
    val numbersByOrder = mNumbersByOrder.asStateFlow()

    init {
        getNumbersByOrderRepetition()
    }

    fun addNumber(params: AddNumberUseCase.Params) = viewModelScope.launch(Main){
        addNumberUseCase(params).fold({
        })
    }

    fun getNumbersByOrderRepetition() = viewModelScope.launch(Main) {
        getNumberByOrderRepetitionUseCase().subscribe({ flow ->
            flow.collectLatest {
                mNumbersByOrder.tryEmit(it.joinToString(" "))
            }
        }, ::onError)
    }

    fun onError(exception: Exception) {
        Timber.e(exception)
    }


}