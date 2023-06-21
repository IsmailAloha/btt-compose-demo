package com.bluetriangle.composedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluetriangle.composedemo.data.Product
import com.bluetriangle.composedemo.data.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val productsRepository: ProductRepository) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(listOf())
    val products: StateFlow<List<Product>> = _products

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val products = productsRepository.listProducts(skipCache = true)
            withContext(Dispatchers.Main) {
                _products.value = products
            }
        }
    }
}