package com.example.apiandroid

import androidx.compose.material3.* // Scaffold, FloatingActionButton, Icon, etc.
import androidx.compose.material.icons.Icons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apiandroid.viewmodel.ProductViewModel
import com.example.apiandroid.ui.composables.AddProductScreen
import com.example.apiandroid.ui.composables.ProductListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: ProductViewModel = viewModel()

            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(onClick = { navController.navigate("add") }) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                }
            ) {
                NavHost(navController, startDestination = "list") {
                    composable("list") {
                        ProductListScreen(
                            products = viewModel.products,
                            isLoading = viewModel.isLoading.value,
                            error = viewModel.errorMessage.value,
                            onRefresh = { viewModel.loadProducts() }
                        )
                    }
                    composable("add") {
                        AddProductScreen(
                            onSubmit = { product, onDone ->
                                viewModel.addProduct(product, onDone)
                            },
                            onBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}