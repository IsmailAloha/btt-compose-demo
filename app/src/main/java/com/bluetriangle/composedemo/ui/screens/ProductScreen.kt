package com.bluetriangle.composedemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.bluetriangle.composedemo.api.StoreService
import com.bluetriangle.composedemo.data.Product
import com.bluetriangle.composedemo.data.ProductRepository
import com.bluetriangle.composedemo.viewmodel.ProductsViewModel

@Composable
fun ProductsScreen(productsViewModel: ProductsViewModel = hiltViewModel()) {
    val products = productsViewModel.products.collectAsState()
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp)) {
        products.value.map { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(item: Product) {
    Row {
        AsyncImage(model = item.image, contentDescription = item.description)
        Column {
            Text(text = item.name)
            Spacer(modifier = Modifier.padding(4.dp))
            Text(text = item.description)
        }
    }
}