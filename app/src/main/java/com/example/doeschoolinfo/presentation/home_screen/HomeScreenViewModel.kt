package com.example.doeschoolinfo.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doeschoolinfo.data.remote.model.SchoolInfoResponseItem
import com.example.doeschoolinfo.domain.repository.SchoolRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.doeschoolinfo.data.util.Result
import com.example.doeschoolinfo.domain.model.SchoolInfoItem

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: SchoolRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState

    init{getSchoolInfo()}

    private fun getSchoolInfo() {
        viewModelScope.launch {
            when (
                val result = repository.getSchoolInfo()
            ) {
                is Result.Success -> {
                    _uiState.value = HomeUiState.Success(result.data)

                }
                is Result.Error -> {
                    _uiState.value = HomeUiState.Error(result.message)
                }

            }

        }


    }

}

sealed interface HomeUiState {
    data class Success(val schoolsInfo: List<SchoolInfoItem>?) : HomeUiState
    data class Error(val message: String? = "") : HomeUiState
    object Loading : HomeUiState
}