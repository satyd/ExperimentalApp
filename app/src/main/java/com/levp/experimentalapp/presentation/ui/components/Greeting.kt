package com.levp.experimentalapp.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Greeting(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column() {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = { onClick() }) {

        }
    }
}