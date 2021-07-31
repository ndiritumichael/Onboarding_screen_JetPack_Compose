package com.devmike.onboardingscreeen.onBoarding

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devmike.onboardingscreeen.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
@Preview
fun OnBoarding(){
val scope = rememberCoroutineScope()
    Column(Modifier.fillMaxSize()) {
        val items = OnBoardingItem.get()
        val statePager = rememberPagerState(items.size)
        TopSection()
        HorizontalPager(state = statePager,
        modifier = Modifier
            .fillMaxSize()
            .weight(0.8f)) { page ->
            OnBoardingItem(items[page])

        }
Row(modifier = Modifier.fillMaxWidth(),
horizontalArrangement = Arrangement.SpaceBetween) {

    HorizontalPagerIndicator(pagerState = statePager
        ,
        modifier = Modifier
            .padding(16.dp)
            .align(Alignment.CenterVertically))


    BottomSection(size = items.size, index = statePager.currentPage) {
        if (statePager.currentPage +1 <items.size) {

            scope.launch {
                statePager.scrollToPage(statePager.currentPage+1)
            }



        }

    }

}

    }
    
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
        TextButton(onClick = { /* implement main screen here*/ },
        modifier = Modifier.align(Alignment.CenterEnd)) {
            Text(text = "Skip",color = MaterialTheme.colors.onBackground)
        }
    }
    
    
    
}

@ExperimentalPagerApi
@Composable

fun BottomSection(size:Int,
                  index:Int,
onNextClicked : ()-> Unit) {
    Box(
        modifier = Modifier
          //  .fillMaxWidth()
            .padding(12.dp)
    ){
//indicators
        //Indicators(size = size, index =index )



//next button

        FloatingActionButton(onClick = onNextClicked,
        modifier = Modifier.align(Alignment.CenterEnd),
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary) {
            Text(text = "Next")
        //  Icon(Icons.Outlined.KeyboardArrowRight, contentDescription = "next")

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

@Composable

fun OnBoardingItem(item: OnBoardingItem){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = item.Image), contentDescription ="Screen1" )
        Text(text = stringResource(id = item.title),
            fontSize = 24.sp,
        color = MaterialTheme.colors.onBackground,
        fontWeight = FontWeight.Bold)

        Text(text = stringResource(id = item.text),
            fontSize = 20.sp,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.8f),
            textAlign = TextAlign.Center
           )


    }

}
