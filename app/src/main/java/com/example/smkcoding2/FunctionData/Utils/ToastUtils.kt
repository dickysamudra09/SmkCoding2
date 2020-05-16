package com.example.smkcoding2.FunctionData.Utils

import android.content.Context
import android.widget.Toast

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

//fun showToastCategory(message: String) {
//    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
//}