package org.umn.dheryl3470week06_b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.umn.dheryl3470week06_b.ui.theme.Dheryl3470Week06_bTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dheryl3470Week06_bTheme {
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
fun TodoScreen(viewModel: TodoViewModel1 = viewModel(),
               modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val todos by viewModel.todos.collectAsState()
    Column(
        Modifier.fillMaxSize().safeDrawingPadding().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("New task") },
            modifier = Modifier.fillMaxWidth())
        Button(onClick = {
            if (text.isNotBlank()){
                viewModel.addTodo(text)
                text = ""
            }
        },modifier = Modifier.fillMaxWidth().height(50.dp)) {
            Text("Add",style = MaterialTheme.typography.bodyLarge)
        }
        LazyColumn() {
            items(todos) { todo ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                ) {
                    Text( text = todo, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
    Dheryl3470Week06_bTheme {
        TodoScreen()
    }
}