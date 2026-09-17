package org.umn.dheryl3470week03_a

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.umn.dheryl3470week03_a.ui.theme.Dheryl3470Week03_aTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dheryl3470Week03_aTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ThemeExample(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ThemeExample(modifier: Modifier = Modifier) {
    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize()
                .systemBarsPadding().padding(all = 20.dp)
        ) {
            // Title
            Text(
                text = "Material 3",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Color, Typography and Shape",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "1. Color",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ColorBox(
                    color = MaterialTheme.colorScheme.primary,
                    text = "Primary"
                )
                ColorBox(
                    color = MaterialTheme.colorScheme.secondary,
                    text = "Secondary"
                )
                ColorBox(
                    color = MaterialTheme.colorScheme.tertiary,
                    text = "Tertiary"
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "2. Typography",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            Card(modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface)){
                Column(modifier = Modifier.padding( all = 16.dp)){
                    Text(text = "Display Large",
                        style = MaterialTheme.typography.displayLarge
                    )
                    Text(text = "Headline Medium",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(text = "Title Large",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "Body Large - This is an example of body text.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(text = "Label Large",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "3. Shape",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row( modifier = Modifier.fillMaxWidth()) {
                ShapeBox(
                    modifier = Modifier.weight(1f), text = "Small",
                    shape = MaterialTheme.shapes.small
                )
                Spacer(modifier = Modifier.width(8.dp))
                ShapeBox(
                    modifier = Modifier.weight(1f), text = "Medium",
                    shape = MaterialTheme.shapes.medium
                )
                Spacer(modifier = Modifier.width(8.dp))
                ShapeBox(
                    modifier = Modifier.weight(1f), text = "Large",
                    shape = MaterialTheme.shapes.large
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Material 3 Button",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Button(onClick = {},
                    modifier = Modifier
                        .width(150.dp).height(50.dp),
                    shape = MaterialTheme.shapes.medium) {
                    Text(
                        text = "Button",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                OutlinedButton(onClick = {},
                    modifier = Modifier
                        .width(150.dp).height(50.dp),
                    shape = RoundedCornerShape( size = 12.dp)) {
                    Text("Outlined")
                }
            }
        }
    }
}

@Composable
fun ColorBox(color: Color, text: String) {
    Column(modifier = Modifier.width(100.dp)) {
        Spacer(modifier = Modifier.fillMaxWidth().height(60.dp)
            .background(
                color = color,
                shape = RoundedCornerShape( size = 12.dp)
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
fun ShapeBox(modifier: Modifier, text: String, shape: Shape){
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.fillMaxWidth().height(70.dp)
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = shape
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = text, style = MaterialTheme.typography.labelMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Dheryl3470Week03_aTheme {
        ThemeExample()
    }
}