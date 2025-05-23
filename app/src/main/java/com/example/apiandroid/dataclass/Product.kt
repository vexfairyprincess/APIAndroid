package com.example.apiandroid.dataclass

import com.google.gson.annotations.SerializedName

data class Product(
    val id: Long? = null,
    val name: String,
    val description: String,
    val price: Double,
    val quantity: Int,
    val category: String
)