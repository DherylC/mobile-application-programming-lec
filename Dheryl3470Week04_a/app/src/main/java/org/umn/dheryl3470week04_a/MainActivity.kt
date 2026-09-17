package org.umn.dheryl3470week04_a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.umn.dheryl3470week04_a.ui.theme.Dheryl3470Week04_aTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dheryl3470Week04_aTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductForm(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProductForm( modifier: Modifier = Modifier) {
    var productName by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    // State for displaying a dialog
    var showDialog by remember { mutableStateOf( false) }

    Column(
        modifier = modifier.fillMaxSize().padding( all = 16.dp)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        OutlinedTextField(value = productName,
            onValueChange = {productName = it},
            label = {
                Text("Product Name")
            })
        OutlinedTextField(value = price,
            onValueChange = { newValue ->
                if(newValue.all { it.isDigit()||it=='.' }){
                    price = newValue
                }
            },
            label = {
                Text("Price")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )

        Button(
            onClick = {
                showDialog = true
            },
            modifier = modifier.fillMaxWidth(fraction = 0.8f)
                .height(50.dp)
        ) {
            Text("Add to Cart")
        }

        if(showDialog){
            AlertDialog(onDismissRequest = {
                showDialog = false},
                title = {
                    Text("Data Product")
                },
                text = {
                    Column() {
                        Text("Product: $productName")
                        Text("Price: $price")
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            productName = ""
                            price = ""
                            showDialog = false
                        }
                    ) {
                        Text("OK")
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductFormPreview() {
    Dheryl3470Week04_aTheme {
        ProductForm()
    }
}