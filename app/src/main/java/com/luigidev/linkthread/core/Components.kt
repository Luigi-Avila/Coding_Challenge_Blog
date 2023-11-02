package com.luigidev.linkthread.core

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TextFieldPost(
    modifier: Modifier,
    textValue: String,
    label: String,
    isNotValid: Boolean = false,
    supportText: String = "",
    oneLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = textValue,
        onValueChange = onTextChanged,
        label = { Text(text = label) },
        isError = isNotValid,
        supportingText = {
            if (isNotValid) {
                Text(text = supportText)
            }
        },
        singleLine = oneLine,
        minLines = minLines,
        maxLines = maxLines
    )
}