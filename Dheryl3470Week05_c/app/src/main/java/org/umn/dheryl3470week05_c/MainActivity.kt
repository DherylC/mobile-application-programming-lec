package org.umn.dheryl3470week05_c

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.umn.dheryl3470week05_c.ui.theme.Dheryl3470Week05_cTheme

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen( route = "home", title = "Home", Icons.Filled.Home)
    object Settings : Screen( route = "settings", title = "Settings", Icons.Filled.Settings)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dheryl3470Week05_cTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BottomNavExample(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavExample(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate( route = "home") },
                    icon = { Icon( imageVector = Icons.Filled.Home,
                        contentDescription = "Home") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate( route = "settings") },
                    icon = { Icon( imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings") },
                    label = { Text("Settings") }
                )

            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding( paddingValues = innerPadding)
        ) {
            composable( route = "home") { HomeScreen() }
            composable( route = "settings") { SettingsScreen() }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavExamplePreview() {
    Dheryl3470Week05_cTheme {
        BottomNavExample()
    }
}