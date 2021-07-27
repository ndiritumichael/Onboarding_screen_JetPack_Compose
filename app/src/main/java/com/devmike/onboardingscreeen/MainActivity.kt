package com.devmike.onboardingscreeen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.devmike.onboardingscreeen.onBoarding.OnBoarding
import com.devmike.onboardingscreeen.ui.theme.OnboardingScreeenTheme
import com.google.accompanist.pager.ExperimentalPagerApi

//https://dribbble.com/shots/13569004-Onboarding
class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnboardingScreeenTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                  //  Greeting("Android")
                    OnBoarding()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OnboardingScreeenTheme {
        Greeting("Android")
    }
}