package com.aman.fakestorecom.screens.home.bag.checkoutflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aman.fakestorecom.R
import com.aman.fakestorecom.screens.common_composable.RedGeneralButton

@Composable
fun SuccessScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .navigationBarsPadding()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.successbag),
                contentDescription =null,
                modifier = Modifier.size(250.dp)
            )
            Text(text = "Success", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
            Text(
                text = "Your order will be delivered soon \nThank you for choosing our app!",
                style = MaterialTheme.typography.labelMedium
            )
        }

        RedGeneralButton(onClick = { /*TODO*/ }, text = "CONTINUE SHOPPING")
    }
}

@Preview(showBackground = true)
@Composable
fun SuccessScreenPreview() {
    val navController = rememberNavController()
    SuccessScreen(navController)
}