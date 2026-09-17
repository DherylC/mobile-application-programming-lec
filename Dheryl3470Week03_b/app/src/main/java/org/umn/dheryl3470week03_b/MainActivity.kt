package org.umn.dheryl3470week03_b

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.umn.dheryl3470week03_b.ui.theme.Dheryl3470Week03_bTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dheryl3470Week03_bTheme {
                LightDarkModeExample()
            }
        }
    }
}

@Composable
fun LightDarkModeExample() {
// Save theme state, false = Light Theme, true = Dark Theme
    var isDarkTheme by remember {
        mutableStateOf( value = false)
    }
    Dheryl3470Week03_bTheme(
        darkTheme = isDarkTheme,
        dynamicColor = false
    ) {
        Scaffold( modifier = Modifier.fillMaxSize()) { innerPadding ->
            ThemeExample(
                modifier = Modifier.padding( paddingValues = innerPadding),
                isDarkTheme = isDarkTheme,
                // Function to change theme
                onThemeChange = {
                    isDarkTheme = !isDarkTheme
                }
            )
        }
    }
}

@Composable
fun ThemeExample(modifier: Modifier = Modifier,
                 isDarkTheme: Boolean, onThemeChange: () -> Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .systemBarsPadding()
        .padding( all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)){
        Text( text = if (isDarkTheme) {
            "Dark Theme"
        } else {
            "Light Theme"
        },
            color = MaterialTheme.colorScheme.primary, fontSize = 24.sp
        )
        Text(
            text = if (isDarkTheme) {
                "The app is currently using Dark Mode"
            } else {
                "The app is currently using Light Mode"
            },
            color = MaterialTheme.colorScheme.onBackground, fontSize = 16.sp
        )
        Surface(
            modifier = Modifier.fillMaxWidth().height(80.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 4.dp
        ){
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = "Surface",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 16.sp
                )
                Text(
                    text = "Surface container",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 12.sp
                )
            }
        }
        Text(
            text = "Primary Color Text",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 18.sp
        )
        OutlinedTextField(
            value = "", onValueChange = {},
            label = { Text(text = "First name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = "", onValueChange = {},
            label = { Text(text = "Last name") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {},
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary)
        ) {
            Text(text = "Submit")
        }
        Button(onClick = {onThemeChange()},
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary)
        ) {
            Text(
                text = if (isDarkTheme) {
                    "Switch to Light Mode"
                } else {
                    "Switch to Dark Mode"
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LightDarkModeExamplePreview(){
    Dheryl3470Week03_bTheme {
        LightDarkModeExample()
    }
}