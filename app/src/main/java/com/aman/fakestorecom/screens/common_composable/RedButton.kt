package com.aman.fakestorecom.screens.common_composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RedGeneralButton(onClick:()->Unit,text:String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Button(
            onClick = { onClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RedGeneralButtonPreview() {
    RedGeneralButton(onClick = {},"test")
}