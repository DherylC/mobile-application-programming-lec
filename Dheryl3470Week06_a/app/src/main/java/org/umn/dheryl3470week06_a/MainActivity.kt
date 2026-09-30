package org.umn.dheryl3470week06_a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.umn.dheryl3470week06_a.ui.theme.Dheryl3470Week06_aTheme
import kotlin.time.Duration.Companion.milliseconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dheryl3470Week06_aTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TodoScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TodoScreen(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val todosFlow = remember {
        MutableStateFlow(listOf<String>())
    }
    val todos by todosFlow.collectAsState()
    val scope = rememberCoroutineScope()
    Column(
        Modifier.fillMaxSize()
            .safeDrawingPadding().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        CircularProgressIndicator()
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("New task") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            if (text.isNotBlank()){
                val task = text
                text = ""
                scope.launch{
                    delay(3000.milliseconds)
                    todosFlow.update { it + task }
                }

            }
        },modifier = Modifier.fillMaxWidth().height(50.dp)) {
            Text("Add",
                style = MaterialTheme.typography.bodyLarge)
        }
        LazyColumn() {
            items(todos) { todo ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = todo,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
    Dheryl3470Week06_aTheme {
        TodoScreen()
    }
}