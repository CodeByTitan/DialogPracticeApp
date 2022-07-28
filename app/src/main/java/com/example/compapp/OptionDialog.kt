package com.example.compapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

@Composable
fun OptionDialog(viewModelStoreOwner: ViewModelStoreOwner) {
    val dialogViewModel = ViewModelProvider(viewModelStoreOwner).get(DialogViewModel::class.java)
    Box(modifier = Modifier.size(300.dp,180.dp),
    contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.align(Alignment.TopStart)) {
            Text(text = "Do You Want To Give Storage Permission", fontFamily = FontFamily.Monospace,
            fontSize = 18.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.size(25.dp,))
            Row{
                Text(text = "Allow",fontFamily = FontFamily.Monospace, fontSize = 15.sp,
                    modifier = Modifier.padding(start = 25.dp).clickable {
                        dialogViewModel.dismissDialog("options")
                        dialogViewModel.allowPermission(true)
                        dialogViewModel.changePermissionText()
                    })
                Text(text = "Deny",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 15.sp, textAlign = TextAlign.End,
                    modifier = Modifier.padding(end = 25.dp)
                        .clickable {
                            dialogViewModel.dismissDialog("options")
                            dialogViewModel.allowPermission(false)
                            dialogViewModel.changePermissionText()
                        }
                    )
            }
        }

    }
}