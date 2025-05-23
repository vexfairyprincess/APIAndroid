package com.example.apiandroid.services

import com.example.apiandroid.dataclass.Product

class ProductRepository(private val api: ApiService) {
    suspend fun fetchAll(): List<Product> = api.getAll()
    suspend fun add(product: Product): Product = api.create(product)
}