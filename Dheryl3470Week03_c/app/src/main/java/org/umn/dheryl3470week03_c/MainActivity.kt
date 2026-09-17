package org.umn.dheryl3470week03_c

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.umn.dheryl3470week03_c.ui.theme.Dheryl3470Week03_cTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var darkTheme by remember {
                mutableStateOf( value = false)
            }
            Dheryl3470Week03_cTheme( darkTheme = darkTheme) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BrandingThemeExample(
                        modifier = Modifier.padding( paddingValues = innerPadding),
                        darkTheme = darkTheme,
                        onThemeChange = {
                            darkTheme = !darkTheme
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun BrandingThemeExample(modifier: Modifier = Modifier,
                         darkTheme: Boolean, onThemeChange: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding( all = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "BLESSY STORE",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Fast and Easy Shopping",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(24.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier.padding( all = 20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                    Text(
                        text = "New Arrivals",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Android Smartphone - Samsung A57",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "Rp 6.500.000",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {},
                modifier = Modifier.fillMaxWidth().height(52.dp)
            ) {
                Text(text = "Buy Now",
                    style = MaterialTheme.typography.titleLarge)
            }
        Spacer(modifier = Modifier.height(24.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier.padding( all = 20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "New Arrivals",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Android Smartphone - Samsung A53",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Rp 4.500.000",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {},
            modifier = Modifier.fillMaxWidth().height(52.dp)
        ) {
            Text(text = "Buy Now",
                style = MaterialTheme.typography.titleLarge)
        }
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector =
                    if (darkTheme)
                        Icons.Default.DarkMode
                    else
                        Icons.Default.LightMode,
                contentDescription =
                    if (darkTheme)
                        "Dark Mode On"
                    else
                        "Light Mode On"
            )
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Text(
                text =
                    if (darkTheme)
                        "Dark Mode"
                    else
                        "Light Mode"
            )
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Switch(
                checked = darkTheme,
                onCheckedChange = {
                    onThemeChange()
                },
                modifier = Modifier.semantics {
                    contentDescription =
                        "Switch untuk mengubah Light Mode dan Dark Mode"
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BrandingThemeExamplePreview() {
    Dheryl3470Week03_cTheme (
        darkTheme = false
    ){
        BrandingThemeExample(
            darkTheme = false,
            onThemeChange = {})
    }
}