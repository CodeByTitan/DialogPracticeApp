package com.example.compapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

@Composable
@Preview(showBackground = true)
fun ProgressBarDialog(@PreviewParameter(FeatureScreenPreviewParamProvider::class) viewModelStoreOwner: ViewModelStoreOwner){
    val dialogViewModel = ViewModelProvider(viewModelStoreOwner).get(DialogViewModel::class.java)
    Dialog(onDismissRequest = { dialogViewModel.showProgressDialog.value },
    DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(200.dp, 150.dp)
                .background(color = Color.White, shape = RoundedCornerShape(15.dp))
        ) {
            Row {
                Text(text = "Setting Profile Picture", textAlign = TextAlign.Start, fontFamily = FontFamily.Monospace,
                    color = Color.Blue, fontSize = 18.sp )
                Spacer(modifier = Modifier.size(15.dp))
                CircularProgressIndicator()
            }

        }
    }
}