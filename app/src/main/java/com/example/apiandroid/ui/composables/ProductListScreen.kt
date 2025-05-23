package com.example.apiandroid.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apiandroid.dataclass.Product

@Composable
fun ProductListScreen(
    products: List<Product>,
    isLoading: Boolean,
    error: String?,
    onRefresh: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (isLoading) {
            CircularProgressIndicator()
        } else if (error != null) {
            Text("Error: $error")
            Button(onClick = onRefresh) { Text("Retry") }
        } else {
            LazyColumn {
                items(products) { product ->
                    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(product.name, style = MaterialTheme.typography.headlineSmall)
                            Text(product.description, style = MaterialTheme.typography.bodyMedium)
                            Text("Price: $${product.price}", style = MaterialTheme.typography.bodyMedium)
                            Text("Quantity: ${product.quantity}", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}