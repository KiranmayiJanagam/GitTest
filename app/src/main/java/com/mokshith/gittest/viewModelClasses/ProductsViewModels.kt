package com.mokshith.gittest.viewModelClasses

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mokshith.gittest.di.ProductsRepo
import com.mokshith.gittest.modelClasses.Category
import com.mokshith.gittest.modelClasses.Product
import com.mokshith.gittest.modelClasses.ProductsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductsViewModels @Inject constructor(
    private val productsRepo: ProductsRepo
) : ViewModel() {

    //private val _state1 = MutableStateFlow<ProductsModel>

    private val _stateCa = MutableStateFlow(emptyList<Category>())

    val stateCa: StateFlow<List<Category>>
        get() = _stateCa


    private val _state = MutableStateFlow(emptyList<Product>())
    val state: StateFlow<List<Product>>
        get() = _state

    init {
       //getProducts()
        getCategories()
    }

    private fun getCategories() {

        viewModelScope.launch((Dispatchers.IO)) {
            productsRepo.getCategoriesList().let { response ->
                try {
                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful) {
                             _stateCa.value = response.body()!!
                            Log.e("TAG", ": ${response.body()}")
                        } else {
                            Log.e("TAG", "------->>  $  <---")
                            _stateCa.value = emptyList()
                        }
                    }
                } catch (e: Exception) {
                    _stateCa.value = emptyList()
                    Log.e("TAG", "------->>  $e")
                }
            }
        }
    }

    private fun getProducts() {
        viewModelScope.launch((Dispatchers.IO)) {
            productsRepo.getProducts().let { response ->
                try {
                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful) {
                            // _state.value = response.body()!!
                            Log.e("TAG", ": ${response.body()}")
                        } else {
                            _state.value = emptyList()
                        }
                    }
                } catch (e: Exception) {
                    _state.value = emptyList()
                    Log.e("TAG", ": ")
                }
            }
        }
    }


}