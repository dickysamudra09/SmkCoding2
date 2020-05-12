package com.example.smkcoding2.FunctionData.Utils

import android.content.Context
import android.os.Message
import android.widget.Toast

fun showToast(context: Context, message: String){
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}