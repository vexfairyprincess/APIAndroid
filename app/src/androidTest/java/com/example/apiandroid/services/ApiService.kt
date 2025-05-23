package com.example.apiandroid.services


import com.example.apiandroid.dataclass.Product
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    @GET("api/products")
    suspend fun getAll(): List<Product>

    @POST("api/products")
    suspend fun create(@Body product: Product): Product
}