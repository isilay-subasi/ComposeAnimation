package com.example.composeanimation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeanimation.ui.theme.ComposeAnimationTheme


const val TAG: String ="AppDebug"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxWithConstraints(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)) {
                    Rocket()
            }
            
        }
    }
}



@Composable
fun Rocket(){
        val resource : Painter
        val infiniteTransition = rememberInfiniteTransition()
        val engineState = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500,
                    easing = LinearEasing
                )
            )
        )
   // Log.d(TAG,"Rocket : ${engineState.value}")
    if(engineState.value <= 0.5f){
        resource= painterResource(id = R.drawable.rocket1)
    }else{
        resource= painterResource(id = R.drawable.rocket2)
    }

    Image(
        modifier = Modifier.width(200.dp).height(200.dp),
        painter = resource,
        contentDescription = "A Rocket"
    )


}






@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAnimationTheme {
        Greeting("Android")
    }
}