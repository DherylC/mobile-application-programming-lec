package org.umn.dheryl3470week02_b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.umn.dheryl3470week02_b.ui.theme.Dheryl3470Week02_bTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dheryl3470Week02_bTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyLayoutExample(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LazyLayoutExample(modifier: Modifier = Modifier) {
    val students = listOf(
        Student("3470", "Dheryl Christofer", "Informatics", R.drawable.dheryl_3470),
        Student("3470", "Dheryl Christofer", "Informatics", R.drawable.dheryl_3470),
        Student("3470", "Dheryl Christofer", "Informatics", R.drawable.dheryl_3470),
        Student("3470", "Dheryl Christofer", "Informatics", R.drawable.dheryl_3470),
        Student("3470", "Dheryl Christofer", "Informatics", R.drawable.dheryl_3470),
        Student("3470", "Dheryl Christofer", "Informatics", R.drawable.dheryl_3470),
        Student("3470", "Dheryl Christofer", "Informatics", R.drawable.dheryl_3470),
        Student("3470", "Dheryl Christofer", "Informatics", R.drawable.dheryl_3470),
        Student("3470", "Dheryl Christofer", "Informatics", R.drawable.dheryl_3470),
        Student("3470", "Dheryl Christofer", "Informatics", R.drawable.dheryl_3470),
        Student("3470", "Dheryl Christofer", "Informatics", R.drawable.dheryl_3470)
    )
    val aiTools = listOf(
        AITool("Copilot", R.drawable.copilot),
        AITool(name = "ChatGPT", logo = R.drawable.chatgpt),
        AITool(name = "BlackBox", logo = R.drawable.blackbox),
        AITool(name = "DeepSeek", logo = R.drawable.deepseek),
        AITool(name = "NotebookLM", logo = R.drawable.notebooklm),
        AITool(name = "Perplexity", logo = R.drawable.perplexity),
        AITool(name = "Cloude", logo = R.drawable.claude),
        AITool(name = "MidJourney", logo = R.drawable.midjourney),
        AITool(name = "Gemini", logo = R.drawable.gemini)
    )
    Column(
        Modifier.fillMaxWidth()
            .systemBarsPadding()
            .padding(all = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Outstanding Student List",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(
            Modifier.fillMaxSize()
                .weight(0.5f)
                .padding(vertical = 4.dp)
        ) {
            items(students) { student ->
                StudentItem(student)
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Popular AI Tools",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF055608),
                modifier = Modifier
                    .padding(horizontal = 6.dp, vertical = 1.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(aiTools) { tool ->
                    AIToolItem(tool)
                }
            }
        }
    }
}

@Composable
fun AIToolItem(tool: AITool) {
    Box(contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = tool.logo),
                contentDescription = tool.name,
                modifier = Modifier.size(60.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(size = 6.dp)
                    )
                    .padding(all = 1.dp)
                    .clip(shape = RoundedCornerShape(size = 6.dp))
            )
            Text(
                text = tool.name,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF055608)
            )
        }
    }
}

@Composable
fun StudentItem(student: Student) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF5A8C36)),
        shape = RoundedCornerShape(size = 16.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(all = 20.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = student.pic),
                contentDescription = student.fullName,
                modifier = Modifier
                    .size(width = 80.dp, height = 100.dp)
                    .border(
                        width = 4.dp,
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(size = 16.dp)
                    )
                    .clip(shape = RoundedCornerShape(size = 16.dp))
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                val labelWidth = 75.dp
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Student ID",
                        fontSize = 12.sp,
                        color = Color.White,
                        modifier = Modifier.width(labelWidth)
                    )
                    Text(
                        text = ": ${student.studentID}",
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Full Name",
                        fontSize = 12.sp,
                        color = Color.White,
                        modifier = Modifier.width(labelWidth)
                    )
                    Text(
                        text = ": ${student.fullName}",
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Major",
                        fontSize = 12.sp,
                        color = Color.White,
                        modifier = Modifier.width(labelWidth)
                    )
                    Text(
                        text = ": ${student.major}",
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyLayoutExamplePreview() {
    Dheryl3470Week02_bTheme {
        LazyLayoutExample()
    }
}