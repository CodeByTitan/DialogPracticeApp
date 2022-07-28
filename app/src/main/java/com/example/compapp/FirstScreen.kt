package com.example.compapp

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController

class FeatureScreenPreviewParamProvider(override val values: Sequence<MainActivity>) : PreviewParameterProvider<MainActivity>
@Composable
fun FirstScreen(
    @PreviewParameter(FeatureScreenPreviewParamProvider::class) viewModelStoreOwner: ViewModelStoreOwner,
    navHostController: NavHostController
){
    val dialogViewModel = ViewModelProvider(viewModelStoreOwner).get(DialogViewModel::class.java)
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.align(Alignment.Center)) {
            Button(onClick = {
                dialogViewModel.showDialog("progress")
                Handler(Looper.getMainLooper()).postDelayed({
                    dialogViewModel.dismissDialog("progress")
                },5000)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue, contentColor = Color.White),
            modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Show ProgressBar Dialog", fontFamily = FontFamily.Monospace,
                fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.size(25.dp))
            Button(onClick = {
                dialogViewModel.showDialog("options")
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray, contentColor = Color.Black),
                modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Show ProgressBar Dialog", fontFamily = FontFamily.Monospace,
                    fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.padding(25.dp))
            Button(onClick = { navHostController.navigate(Screen.Second.route) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black
            )) {
               Text(text = "Navigate To Second Screen",
                   fontFamily = FontFamily.Default,
                   fontSize = 18.sp,
                   color = Color.White
               )
            }
        }
    }
}