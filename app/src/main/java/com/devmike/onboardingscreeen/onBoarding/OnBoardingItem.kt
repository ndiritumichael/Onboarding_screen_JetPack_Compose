package com.devmike.onboardingscreeen.onBoarding

import com.devmike.onboardingscreeen.R

data class OnBoardingItem(
    val title:Int,
    val text :Int,
    val Image : Int,
){
    companion object{

        fun get() = listOf(
                OnBoardingItem(R.string.title1,R.string.text1,R.drawable.screen1),
                OnBoardingItem(R.string.title2,R.string.text2,R.drawable.screen2),
                OnBoardingItem(R.string.title3,R.string.text3,R.drawable.screen3)
            )

    }


}
