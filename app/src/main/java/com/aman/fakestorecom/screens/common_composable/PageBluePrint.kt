package com.aman.fakestorecom.screens.common_composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageBluePrint(
    title: String,
    rightIcon:ImageVector,
    onBackIconClick:()->Unit,
    onRightIconClick:()->Unit,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = { onBackIconClick() }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                contentDescription ="Back button"
                            )
                        }
                         },
                    actions = {
                        IconButton(
                            onClick = { onRightIconClick() },
                        ){
                            Icon(
                                imageVector = rightIcon,
                                contentDescription = "Search Button"
                            )
                        }
                    },


                    title = {
                        Text(
                            text = title,
                            color = Color.Black // Set title color to red
                        )
                    },
                    scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
                    modifier = Modifier.height(35.dp)
                )
            },
            content = {
                content()
            }
        )

    }

}


@Preview
@Composable
fun CustomTopBarPreview() {
    PageBluePrint("FakeCommerce.com",Icons.Default.Search,{},{},content = {})
}