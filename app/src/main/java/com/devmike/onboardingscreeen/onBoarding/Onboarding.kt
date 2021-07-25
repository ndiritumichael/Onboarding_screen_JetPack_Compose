package com.devmike.onboardingscreeen.onBoarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun OnBoarding(){
    
}

@Composable
@Preview
fun TopSection(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)){
        
        
        IconButton(onClick = { /*TODO*/ },
        modifier = Modifier.align(Alignment.CenterStart)) {
            Icon(Icons.Outlined.KeyboardArrowLeft,null)
            
        }
        
        TextButton(onClick = { /*TODO*/ },
        modifier = Modifier.align(Alignment.CenterEnd)) {
            Text(text = "Skip",color = MaterialTheme.colors.background)
        }
    }
    
    
    
}