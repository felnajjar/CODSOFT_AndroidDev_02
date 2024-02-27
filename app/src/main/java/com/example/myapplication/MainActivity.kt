package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }


    var exp: String by mutableStateOf("0")

    @Composable
    fun App(modifier: Modifier = Modifier) {
        fun Input(num: String) {
            if (exp == "Error" || exp == "0") {
                exp = num
            } else if (exp.length < 20) {
                exp += num
            }

        }

        fun evaluateExpression() {
            try {
                val result = ExpressionBuilder(exp).build().evaluate()
                exp = result.toInt().toString()
            } catch (e: Exception) {
                exp = "Error"
            }
        }


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)


            ) {
                Text(
                    text = exp,
                    modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(14.dp)
                        )
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 10.dp),
                    textAlign = TextAlign.Right,
                    fontSize = 24.sp,

                    )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                Button(
                    onClick = { Input("7") },
                    colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = "7")
                }
                Button(
                    onClick = { Input("8") },
                    colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = "8")
                }
                Button(
                    onClick = { Input("9") },
                    colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = "9")
                }
                Button(onClick = { Input("/") }) {
                    Text(text = "/")
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                Button(
                    onClick = { Input("4") },
                    colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = "4")
                }
                Button(
                    onClick = { Input("5") },
                    colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = "5")
                }
                Button(
                    onClick = { Input("6") },
                    colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = "6")
                }
                Button(onClick = { Input("*") }) {
                    Text(text = "x")
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()

            ) {

                Button(
                    onClick = { Input("1") },
                    colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = "1")
                }
                Button(
                    onClick = { Input("2") },
                    colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = "2")
                }
                Button(
                    onClick = { Input("3") },
                    colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = "3")
                }
                Button(onClick = { Input("+") }) {
                    Text(text = "+")
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                Button(
                    onClick = { Input("0") },
                    colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = "0")
                }
                Button(
                    onClick = {
                        if (exp.length > 1) {
                            exp = exp.dropLast(1)
                        } else {
                            exp = "0"
                        }
                    },
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = Color(
                            0xFF888888
                        )
                    )
                ) {
                    Text(text = "<")
                }
                Button(
                    onClick = {
                        exp = "0"
                    },
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = Color(
                            0xFF888888
                        )
                    )
                ) {
                    Text(text = "C")
                }
                Button(
                    onClick = {
                        evaluateExpression()
                    },
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = Color(
                            0xFFF5AC18
                        )
                    )
                ) {
                    Text(text = "=")
                }
            }

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun CalculatorPreview() {
        MyApplicationTheme {
            App()
        }
    }
}
