package org.umn.dheryl3470week04_b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.umn.dheryl3470week04_b.ui.theme.Dheryl3470Week04_bTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dheryl3470Week04_bTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProductScreen( modifier: Modifier = Modifier) {
    var productName by remember { mutableStateOf( value = "") }
    var price by remember { mutableStateOf( value = "") }
    var showDialog by remember { mutableStateOf( value = false) }
    ProductForm(
        modifier = modifier,
        productName = productName,
        price = price,
        showDialog = showDialog,
        onProductNameChange = {
            productName = it
        },
        onPriceChange = {
            price = it
        },
        onSaveClick = {
            showDialog = true
        },
        onDismissDialog = {
            showDialog = false
        },
        onConfirmDialog = {
            productName = ""
            price = ""
            showDialog = false
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    Dheryl3470Week04_bTheme {
        ProductScreen()
    }
}