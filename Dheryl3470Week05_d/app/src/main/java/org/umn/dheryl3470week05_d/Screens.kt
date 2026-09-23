package org.umn.dheryl3470week05_d

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("This is Home Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun ProfileScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("This is Profile Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("This is Settings Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun ThemeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("This is Theme Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun SecurityScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("This is Security Screen", style = MaterialTheme.typography.headlineMedium)
    }
}