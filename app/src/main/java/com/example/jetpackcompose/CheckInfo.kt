package com.example.jetpackcompose

import android.widget.CheckBox

data class CheckInfo(
    val label: String,
    var Checked: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)