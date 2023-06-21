package com.bluetriangle.composedemo.data

import com.bluetriangle.composedemo.api.StoreService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val storeService: StoreService
) {

    private var products: List<Product> = emptyList()

    suspend fun listProducts(skipCache: Boolean = false): List<Product> {
        if (products.isEmpty() || skipCache) {
            products = storeService.listProducts()
        }
        return products
    }
}