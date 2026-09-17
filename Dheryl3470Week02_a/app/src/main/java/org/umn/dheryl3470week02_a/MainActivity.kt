package org.umn.dheryl3470week02_a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.umn.dheryl3470week02_a.ui.theme.Dheryl3470Week02_aTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dheryl3470Week02_aTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LayoutExample(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LayoutExample(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(all = 16.dp)
        .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Arranging the Layout", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(10.dp))
        RoundedRectangle()
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            SmallRectangle()
            SmallRectangle()
        }
        Spacer(modifier = Modifier.height(10.dp))
        RoundedRectangle()
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth()){
            Column(modifier = Modifier.fillMaxWidth(fraction = 0.2f)) {
                StudentHeadshot()
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column() {
                Text( text = "Full Name ", fontSize = 12.sp)
                Text( text = "Student ID ", fontSize = 12.sp)
                Text( text = "Class ", fontSize = 12.sp)
                Text( text = "Address ", fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column() {
                Text( text = ": ", fontSize = 12.sp)
                Text( text = ": ", fontSize = 12.sp)
                Text( text = ": ", fontSize = 12.sp)
                Text( text = ": ", fontSize = 12.sp)
            }
            Column() {
                Text( text = "Dheryl Christofer", fontSize = 12.sp)
                Text( text = "113470", fontSize = 12.sp)
                Text( text = "C", fontSize = 12.sp)
                Text( text = "Jl. Scientia Boulevard, Gading Serpong, " +
                        "Kel. Curug Sangereng, Kec. Kelapa Dua, Kab. Tangerang," +
                        "Prop. Banten 15810, Indonesia", fontSize = 12.sp)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            TinyRectangle()
            TinyRectangle()
            TinyRectangle()
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            SmallRectangle()
            SmallRectangle()
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            BigRectangle()
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            RoundedRectangle()
        }
    }
}

@Composable
fun RoundedRectangle(){
    Box(modifier = Modifier.fillMaxWidth()
        .height(50.dp)
        .clip(shape = RoundedCornerShape(size = 6.dp))
        .background(Color(0xFF5A8C36)))
}

@Composable
fun BigRectangle() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFFAABc36))
    )
}

@Composable
fun SmallRectangle() {
    Box(
        modifier = Modifier
            .size(width = 175.dp, height = 50.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFF5A8C36))
    )
}

@Composable
fun TinyRectangle() {
    Box(
        modifier = Modifier
            .size(width = 111.dp, height = 50.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFF5A8C36))
    )
}

@Composable
fun StudentHeadshot(){
    Image(painter = painterResource(id = R.drawable.dheryl_3470),
        contentDescription = "Dheryl3470Week02_a",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .border(width = 4.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(size = 16.dp)
            )
            .clip(shape = RoundedCornerShape(size = 16.dp)))
}

@Preview(showBackground = true)
@Composable
fun LayoutExamplePreview() {
    Dheryl3470Week02_aTheme {
        LayoutExample()
    }
}