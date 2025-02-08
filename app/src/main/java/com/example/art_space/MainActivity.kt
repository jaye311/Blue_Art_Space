package com.example.art_space

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art_space.ui.theme.Art_SpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Art_SpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun Greeting( modifier: Modifier = Modifier) {
    val imageAmt=3
    var result by remember{mutableIntStateOf(1)}
    val img = when(result){
        1 -> R.drawable.koivexelsfreeimage
        2 -> R.drawable.waterripplecolor
        3 -> R.drawable.blueglassshell
        else -> R.drawable.ic_launcher_foreground
    }
    val desc = when(result){
        1 -> "Koi fish and lotus flower pattern"
        2 -> "Chromatic water droplet vortex ripple"
        3 -> "Blue glass shells"
        else -> "Error"
    }
    val src = when(result){
        1 -> "FreeImages.com/Vexels"
        2 -> "FreeImages.com/wilhelmien"
        3 -> "FreeImages.com/coralsea"
        else -> "Hmm what did you do?"
    }
    Column(
        modifier = modifier.fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            modifier = Modifier.background(Color(0xFF2196F3)).fillMaxWidth().padding(vertical = 40.dp),
            text = "Art Gallery",
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
        Image(
            painter = painterResource(img),
            null,
            modifier = Modifier.padding(bottom = 220.dp).absoluteOffset(y= 200.dp).width(360.dp).height(230.dp)
        )
        Text(
            text = "Description: $desc",
        )
        Text(
            text = "Source: $src",
        )
        Spacer(modifier = Modifier.height(150.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(onClick ={
                if(result == 1)
                    result = imageAmt
                else
                    result--
                },
                modifier=Modifier.padding(horizontal = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = null
                )
            }
            Button(onClick ={
                if(result == imageAmt)
                    result = 1
                else
                    result++
                },
                modifier=Modifier.padding(horizontal = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Art_SpaceTheme {
        Greeting()
    }
}