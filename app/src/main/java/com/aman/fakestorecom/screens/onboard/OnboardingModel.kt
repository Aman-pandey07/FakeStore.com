package com.aman.fakestorecom.screens.onboard

import androidx.annotation.DrawableRes
import com.aman.fakestorecom.R

sealed class OnboardingModel(
    @DrawableRes val image: Int,
) {

    data object FirstPage : OnboardingModel(
        image = R.drawable.sp01,
    )

    data object SecondPage : OnboardingModel(
        image = R.drawable.sp02,
    )

    data object ThirdPages : OnboardingModel(
        image = R.drawable.sp03,
    )

    data object FourthPages : OnboardingModel(
        image = R.drawable.sp04,
    )


}