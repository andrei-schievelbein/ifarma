package br.com.noke.ifarma.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MarkUnreadChatAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.noke.ifarma.R

@Composable
fun FarmaciaScreen() {
    Column {
        Carussel()
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(370.dp)
                .height(1.dp)
                .background(Color.Gray)
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = "Pedido em análise em 4 Estabelecimentos",
            fontFamily = FontFamily.Default,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))

        Column {
            // ... (restante da tela) ...

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(valores) { item -> // Gera 6 cards

                    CardFarmacia(
                        imagem = item.imagem,
                        remedios = item.remedios,
                        situacao = item.situacao,
                        valor = item.valor
                    )
                }
            }
        }

//        CardFarmacia()
    }
}


@Composable
fun CardFarmacia(
    imagem: Int,
    remedios: List<String>,
    situacao: String,
//    isMelhorPreco: Boolean,
    valor: Double
) {

    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
//                .background(Color.Yellow)
        ) {
            Column(
                modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
                    .fillMaxSize()
//                  .align(Alignment.CenterVertically)
                    .height(100.dp)
                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp)
//                    .background(Color.Red)
                    .weight(0.3f)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFDCDCDC),
                        shape = RoundedCornerShape(15.dp)
                    )


            ) {
                //Row Logo e situação
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(topEnd = 15.dp))
//                        .height(25.dp)


//                        .background(Color.Blue)
                ) {
                    Row(
                        modifier = Modifier
                            .width(200.dp)
                            .height(25.dp)
                            .clip(shape = RoundedCornerShape(topStart = 15.dp))
//                            .background(Color.Cyan)
                    ) {
                        Image(
                            painter = painterResource(id = imagem),
                            contentDescription = "logo",
                            contentScale = ContentScale.FillHeight
                        )
                    }
                    Row(
                        modifier = Modifier
//                            .width(18.dp)
                            .fillMaxWidth()
                            .height(25.dp)
                            .background(
                                when (situacao) {
                                    "Concluído" -> Color(0xFFE4FAD9)
                                    "Requer atenção" -> Color(0xFFFFECB3)
                                    else -> Color(0xFFBBDEFB)
                                }
                            ),
//                            .background(Color(0xFFE4FAD9)),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            modifier = Modifier.offset(x = (-5).dp),
                            text = situacao,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                        )

                    }


                }
                //Row Descrição, chat e valor
                Row(
                    modifier = Modifier
                        .fillMaxSize()

//                    .background(Color.Green)
                )
                {
                    Column(
                        modifier = Modifier
                            .width(200.dp)
                            .fillMaxHeight()
                            .clip(shape = RoundedCornerShape(bottomStart = 15.dp))
//                        .background(Color.Red),

                    ) {
//
//                        val myTexts = listOf(
//                            "Aspirina Prevent 100mg 30 Com...",
//                            "Advil 400mg - 8 cápsulas ",
//                            "Repelente Off Kids loção",
//                            "Sal de frutas Eno - 2 Envelopes"
//                        )
//                        myTexts.forEach { text ->
//                            Text(
//                                modifier = Modifier.offset(x = (8).dp),
//                                text = text,
//                                fontSize = 11.sp
//                            )
//                        }
                        LazyColumn { // Efficient for potentially longer lists
                            items(remedios) { remedio ->
                                Text(
                                    modifier = Modifier.offset(x = (8).dp),
                                    text = remedio,
                                    fontSize = 11.sp
                                )
                            }
                        }


                    }
                    Row(
                        modifier = Modifier
                            .width(50.dp)
                            .fillMaxHeight(),
//                        .background(Color.Blue),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center

                    ) {

                        Icon(
                            Icons.Filled.MarkUnreadChatAlt, "menu",
                            modifier = Modifier
                                .offset(y = (-4).dp)
                                .height(35.dp)
                                .width(35.dp),
                            tint = Color.Gray

                        )

                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(shape = RoundedCornerShape(bottomEnd = 15.dp))
//                        .background(Color.Magenta),

                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
//                            .background(Color.Green)'
                        ) {
                                Text(
                                    text = "Melhor  preço! ",
                                    fontSize = 14.sp,
                                    color = Color(0xFF59C606),
                                    fontWeight = FontWeight.SemiBold,
                                )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
//                            .background(Color.Red),
                            horizontalAlignment = Alignment.End,
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Text(
                                modifier = Modifier.offset(y = (-8).dp),
                                text = if (valor > 0) "R$ ${valor} " else "",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }

                    }
                }


            }

        }
    }


}

//@Preview()
//@Composable
//fun Preview() {
//    CardFarmacia(
//        imagem = R.drawable.drogariaabc,
//        remedios = listOf("Aspirina Prevent 100mg 30 Com..."),
//        situacao = "",
//        valor = 10.0,
//        melhorPreco = item.valor == menorPreco
//    )
//}