package br.com.noke.ifarma.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.font.FontWeight
import br.com.noke.ifarma.R
import kotlinx.coroutines.delay

@Composable
fun Carussel() {
    val selectedIndex = remember { mutableStateOf(-1) }
    val selectedImageIndex = remember { mutableStateOf(0) }
    val selectedTextIndex = remember { mutableStateOf(0) }
    val selectedSubTextIndex = remember { mutableStateOf(0) }

    val imageList = listOf(R.drawable.img, R.drawable.img2, R.drawable.img3)
    val textList = listOf(
        "Rastreie seus Pedidos",
        "Pedido Enviado",
        "ifarma"
    )

    val subTextList = listOf(
        "Rastreamento em\n tempo real",
        "Aguarde as farmácias\n parceiras responderem",
        "Conte sempre\n conosco"
    )

    val timer = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = timer.value) {
        while (true) {
            delay(4000)
            timer.value += 1
            if (timer.value >= imageList.size) {
                timer.value = 0
            }
            selectedImageIndex.value = timer.value
            selectedIndex.value = timer.value
            selectedTextIndex.value = timer.value
            selectedSubTextIndex.value = timer.value
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(195.dp)
//            .background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp, 12.dp, 15.dp, 0.dp)
                .fillMaxWidth()
                .height(150.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(Color.Blue)



        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomStart // Opcional para centralizar o conteúdo
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = imageList[selectedImageIndex.value]),
                    contentDescription = "Image",
                    contentScale = ContentScale.FillWidth
                )
                Text(
                    modifier = Modifier
                        .offset(x = 8.dp, y = -90.dp),
                    text = textList[selectedTextIndex.value],
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    modifier = Modifier
                        .offset(x = 8.dp, y = -40.dp),
                    text = subTextList[selectedSubTextIndex.value],
                    fontSize = 19.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(30.dp),
//            .border(1.dp, Color.Black),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center


        ){

            for (i in 0..2) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(20.dp)
                        .clip(shape = CircleShape)
                        .clickable {
                            selectedIndex.value = i
                            selectedImageIndex.value = i
                            selectedTextIndex.value = i
                        }
                        .background(if (selectedIndex.value == i) Color(0xFFFFF59D) else Color.LightGray)
                )
            }
        }



    }
}