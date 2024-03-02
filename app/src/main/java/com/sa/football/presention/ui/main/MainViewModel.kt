package com.sa.football.presention.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sa.football.data.core.Resource
import com.sa.football.domain.models.CompetitionModel
import com.sa.football.domain.usecase.GetCompetitionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCompetitionsUseCase: GetCompetitionsUseCase,
) :
    ViewModel() {


    private val _getCompetitionsResponse =  MutableStateFlow<Resource<List<CompetitionModel>>>(Resource.Idle())
    val getCompetitionsResponse = _getCompetitionsResponse.asStateFlow()

    init {
        getCompetitions()
    }

    private var competitionsJob: Job? = null

    private fun getCompetitions() {
        competitionsJob?.cancel()
        competitionsJob = viewModelScope.launch(Dispatchers.IO) {
            getCompetitionsUseCase().collect {
                _getCompetitionsResponse.emit(it)
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        competitionsJob?.cancel()
    }

}