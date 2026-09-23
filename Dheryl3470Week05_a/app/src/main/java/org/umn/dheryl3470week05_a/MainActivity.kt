package org.umn.dheryl3470week05_a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.umn.dheryl3470week05_a.ui.theme.Dheryl3470Week05_aTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dheryl3470Week05_aTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SimpleNav(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SimpleNav( modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf( value = "Screen1") }

    when (currentScreen) {
        "Screen1" -> Screen1(onNavigate = { currentScreen = "Screen2" })
        "Screen2" -> Screen2(onNavigate = { currentScreen = "Screen1" })
    }
}

@Composable
fun Screen1(onNavigate: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 1",
            style = MaterialTheme.typography.displaySmall)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigate,
            modifier = Modifier.padding( all = 16.dp)
                .width(200.dp)
                .height(50.dp),
            shape = MaterialTheme.shapes.medium) {
            Text("Go to Screen 2")
        }
    }
}

@Composable
fun Screen2(onNavigate: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 2",
            style = MaterialTheme.typography.displaySmall)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigate,
            modifier = Modifier.padding( all = 16.dp)
                .width(200.dp)
                .height(50.dp),
            shape = MaterialTheme.shapes.medium) {
            Text("Go Back to Screen 1")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SimpleNavPreview() {
    Dheryl3470Week05_aTheme {
        SimpleNav()
    }
}