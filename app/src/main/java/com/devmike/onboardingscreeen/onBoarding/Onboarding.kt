package com.devmike.onboardingscreeen.onBoarding

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
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
        
        //back button
        IconButton(onClick = { /*TODO*/ },
        modifier = Modifier.align(Alignment.CenterStart)) {
            Icon(Icons.Outlined.KeyboardArrowLeft,null)
            
        }

        //skip test button
        TextButton(onClick = { /*TODO*/ },
        modifier = Modifier.align(Alignment.CenterEnd)) {
            Text(text = "Skip",color = MaterialTheme.colors.onBackground)
        }
    }
    
    
    
}

@Composable

fun BottomSection(size:Int,
                  index:Int,
onNextClicked : ()-> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ){
//indicators
        Indicators(size = size, index =index )


//next button

        FloatingActionButton(onClick = onNextClicked,
        modifier = Modifier.align(Alignment.CenterEnd),
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary) {
            Icon(Icons.Outlined.KeyboardArrowRight, contentDescription = "next")

        }




    }
}

@Composable
fun BoxScope.Indicators(size : Int,index:Int){

    Row (
        verticalAlignment =  Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.align(Alignment.CenterStart)
    ){
        repeat(size){
            Indicator(isSelected  = it == index)
        }

    }
}

@Composable
//@PreviewParameter()
fun Indicator(isSelected:Boolean){

    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp,
    animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy))
    Box(modifier = Modifier
        .height(10.dp)
        .width(width.value)
        .clip(CircleShape)
        .background(
            if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground.copy(
                alpha = 0.5f
            )
        )

        ){


    }

}