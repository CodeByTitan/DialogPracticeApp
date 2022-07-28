package com.example.compapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController

@Composable
fun SecondScreen(
    viewModelStoreOwner: ViewModelStoreOwner,
    navHostController: NavHostController
){
    val dialogViewModel = ViewModelProvider(viewModelStoreOwner).get(DialogViewModel::class.java)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = dialogViewModel.permissionText.value ,
            fontSize = 25.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.Green,
            textAlign = TextAlign.Center)
    }
    Image(painter = painterResource(id = R.drawable.ic_back),contentDescription = null,
        modifier = Modifier.wrapContentSize()
            .padding(15.dp)
            .clickable {
                       navHostController.navigate(Screen.First.route)
            }
        ,
        alignment = Alignment.TopStart,
    )
}