package org.umn.dheryl3470week05_d

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.umn.dheryl3470week05_d.ui.theme.Dheryl3470Week05_dTheme

sealed class DrawerScreen(val route: String, val title: String, val icon: ImageVector) {
    object Home : DrawerScreen(route = "home", title = "Home", Icons.Default.Home)
    object Profile : DrawerScreen(route = "profile", title = "Profile", Icons.Default.AccountCircle)
    object Settings : DrawerScreen(route = "settings", title = "Settings", Icons.Default.Settings)
    object Theme : DrawerScreen(route = "theme", title = "Theme", Icons.Default.Palette)
    object Security : DrawerScreen(route = "security", title = "Security", Icons.Default.Lock)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dheryl3470Week05_dTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreenSide(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DrawerContent(
    currentScreen: DrawerScreen,
    onItemClick: (DrawerScreen) -> Unit
) {
    val items = listOf(
        DrawerScreen.Home,
        DrawerScreen.Profile,
        DrawerScreen.Settings,
        DrawerScreen.Theme,
        DrawerScreen.Security
    )

    ModalDrawerSheet {
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Menu",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(all = 16.dp)
        )
        HorizontalDivider()

        items.forEach { screen ->
            NavigationDrawerItem(
                label = { Text(screen.title) },
                selected = currentScreen.route == screen.route,
                icon = {
                    Icon(imageVector = screen.icon, contentDescription = screen.title)
                },
                onClick = { onItemClick(screen) },
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenSide(modifier: Modifier = Modifier) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var currentScreen by remember { mutableStateOf<DrawerScreen>(value = DrawerScreen.Home) }
    var menuExpanded by remember { mutableStateOf(false) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                currentScreen = currentScreen,
                onItemClick = { screen ->
                    currentScreen = screen
                    scope.launch { drawerState.close() }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Dheryl 3470") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = { menuExpanded = true }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More options"
                            )
                        }

                        DropdownMenu(
                            expanded = menuExpanded,
                            onDismissRequest = { menuExpanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Theme") },
                                onClick = {
                                    menuExpanded = false
                                    currentScreen = DrawerScreen.Theme
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Security") },
                                onClick = {
                                    menuExpanded = false
                                    currentScreen = DrawerScreen.Security
                                }
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Box(modifier = modifier.padding(paddingValues = innerPadding)) {
                when (currentScreen) {
                    DrawerScreen.Home -> HomeScreen()
                    DrawerScreen.Profile -> ProfileScreen()
                    DrawerScreen.Settings -> SettingsScreen()
                    DrawerScreen.Theme -> ThemeScreen()
                    DrawerScreen.Security -> SecurityScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenSidePreview() {
    Dheryl3470Week05_dTheme {
        MainScreenSide()
    }
}