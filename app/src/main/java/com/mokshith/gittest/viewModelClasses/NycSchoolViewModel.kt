package com.mokshith.gittest.viewModelClasses

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mokshith.gittest.di.ProductsRepo
import com.mokshith.gittest.modelClasses.NycSchoolsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NycSchoolViewModel @Inject constructor(
    private val productsRepo: ProductsRepo
) : ViewModel() {

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean>
        get() = _loading

    private val _stateNyc = MutableStateFlow(emptyList<NycSchoolsModel>())

    val stateNyc: StateFlow<List<NycSchoolsModel>>
        get() = _stateNyc

    init {
        getNycSchoolsData()
    }

    private fun getNycSchoolsData() {
        viewModelScope.launch(Dispatchers.IO) {
            productsRepo.getNycSchools().let { response ->
                withContext(Dispatchers.Main){
                    _loading.value = false
                    try {
                        if (response.isSuccessful) {
                            _stateNyc.value = response.body()!!
                            Log.e("TAG", "getNycSchoolsData:", )
                        } else {
                            Log.e("TAG", "getNycSchoolsData: ", )
                            _stateNyc.value = emptyList()
                        }
                    } catch (e: Exception) {
                        Log.e("TAG", "getNycSchoolsData: $e", )
                    }
                }
            }
        }
    }
}