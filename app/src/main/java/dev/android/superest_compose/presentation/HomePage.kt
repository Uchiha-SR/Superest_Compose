package dev.android.superest_compose.presentation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.android.superest_compose.presentation.component.TopBar
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import dev.android.superest_compose.presentation.component.SearchBar
import dev.android.superest_compose.ui.theme.Superest_ComposeTheme
@Preview

@Composable
fun HomePage(){
    val textState = remember { mutableStateOf(TextFieldValue("")) }
     //   Surface(color = MaterialTheme.colors.background) {
            LazyColumn(modifier = Modifier.fillMaxHeight()) {
                item {
                    TopBar()
                    SearchBar(textState)
                }
}
        }

