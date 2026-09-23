package org.umn.dheryl3470week05_b

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp

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
