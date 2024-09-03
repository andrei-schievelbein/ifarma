package br.com.noke.ifarma.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.noke.ifarma.navigation.Screens


@Composable
fun HomeScreen() {

    Column {
        Carussel()
        ReceitaEnvio()
        Spacer(modifier = Modifier.height(5.dp))
        Formulario()
        Enviar()
    }
}

@Composable
fun Enviar(modifier: Modifier = Modifier) {


    Button(
        onClick = { },
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(horizontal = 14.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF59c606))
//            containerColor = Color(0xFF59c606)
    ) {
        Text(
            text = "Enviar Pedido!",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(
                top = 1.dp
            )
        )
    }
}

@Composable
fun ReceitaEnvio() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(Color(0xFFF2F2F2))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(Color.Gray)
        ) {
            Row(
                modifier = Modifier
                    .width(50.dp)
                    .height(110.dp)
                    .background(Color(0xFFFEF7E6))
                //.border(BorderStroke(1.dp, Color.Magenta))
            ) {
                Icon(
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            start = 13.dp,
                            end = 10.dp,
                            bottom = 10.dp
                        ),
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "Book"
                )
            }
            Row(
                modifier = Modifier
                    .width(260.dp)
                    .height(110.dp)
                    .background(Color(0xFFFEF7E6))
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            top = 18.dp,
                            start = 15.dp,
                            end = 10.dp,
                            bottom = 10.dp
                        )
                ) {

                    Text(
                        text = "Já tem a receita?",
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(modifier = Modifier
                        .offset(y = (-10).dp),
                        text = "Envie o seu pedido e receba seus\nmedicamentos!",
                        fontFamily = FontFamily.Default,
                        fontSize = 12.sp,
                        maxLines = 2,
                        lineHeight = 16.sp
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .height(110.dp)
                    .background(Color(0xFFFEF7E6))
            ) {
                Icon(
                    modifier = Modifier.padding(
                        top = 40.dp,
                        start = 15.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    ),
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Seta para a direita"
                )
            }
        }
    }
}

@Preview
@Composable
private fun ReceitaEnvioPreview() {
    ReceitaEnvio()
}



