package com.example.compapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel

class DialogViewModel : ViewModel() {
    var showProgressDialog = mutableStateOf(false)
    private set

    var permission = mutableStateOf(false)
    private set

    var permissionText = mutableStateOf("No Action Taken For Permission")
    private set

    var showOptionDialog = mutableStateOf(false)
    private set

    fun changePermissionText(){
        if(permission.value) {
            permissionText.value = "Permission GRANTED"
        }else{
            permissionText.value = "Permission DENIED"
        }
    }

    fun allowPermission(boolean: Boolean) {
        permission.value = boolean
    }

    fun showDialog(type: String){
        changeDialogState(type,true)
    }

    private fun changeDialogState(type: String, boolean: Boolean){
        when(type){
            "Progress".lowercase() -> {
                showProgressDialog.value = boolean
            }
            "Options".lowercase() -> {
                showOptionDialog.value = boolean
            }
        }
    }
    fun dismissDialog(type: String){
        changeDialogState(type,false)
    }
}