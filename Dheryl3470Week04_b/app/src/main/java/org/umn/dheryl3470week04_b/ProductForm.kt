package org.umn.dheryl3470week04_b

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.*

@Composable
fun ProductForm(modifier: Modifier = Modifier,
                productName: String, price: String, showDialog: Boolean,

                onProductNameChange: (String) -> Unit,
                onPriceChange: (String) -> Unit,
                onSaveClick: () -> Unit,
                onDismissDialog: () -> Unit,
                onConfirmDialog: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize().padding( all = 16.dp).systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OutlinedTextField(
            value = productName,
            onValueChange = onProductNameChange,
            label = { Text("Product Name") }
        )
        OutlinedTextField(
            value = price,
            onValueChange = { newValue ->
                if ( newValue.all {
                        it.isDigit() || it == '.'
                    }
                ) { onPriceChange(newValue) }
            },
            label = {Text("Price")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )
        Button(onClick = onSaveClick,
            modifier = Modifier.fillMaxWidth( fraction = 0.7f).height(50.dp)
        ) {Text("Add to Cart")}
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismissDialog,
            title = { Text("Product Details") },
            text = {
                Column {
                    Text("Product: $productName")
                    Text("Price: $price")
                }
            },
            confirmButton = {
                Button(onClick = onConfirmDialog) {
                    Text("OK")
                }
            }
        )
    }
}