package com.joelkanyi.komposepickerdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joelkanyi.jcomposecountrycodepicker.component.KomposeCountryCodePicker
import com.joelkanyi.komposepickerdemo.ui.theme.KomposePickerDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KomposePickerDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val phoneNumber = rememberSaveable { mutableStateOf("") }
                    val phoneNumber2 = rememberSaveable { mutableStateOf("") }

                    Column(
                        Modifier.padding(PaddingValues(16.dp)),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        KomposeCountryCodePicker(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = phoneNumber.value,
                            onValueChange = { phoneNumber.value = it },
                            placeholder = { Text(text = "Phone Number") },
                            shape = MaterialTheme.shapes.medium,
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                            ),
                        )

                        TextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = phoneNumber2.value,
                            onValueChange = { phoneNumber2.value = it },
                            placeholder = { Text(text = "Phone Number") },
                            leadingIcon = {
                                KomposeCountryCodePicker(
                                    modifier = Modifier,
                                    showOnlyCountryCodePicker = true,
                                    showCountryFlag = false,
                                )
                            },
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                            ),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KomposePickerDemoTheme {
        Greeting("Android")
    }
}
