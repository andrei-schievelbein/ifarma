package br.com.noke.ifarma.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Formulario() {
    val remedios = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        AddRemedio(onRemedioAdd = { remedioNome ->
            remedios.add(remedioNome)
        })
        RemediosList(remedios = remedios)
    }
}
@Composable
fun AddRemedio(
    modifier: Modifier = Modifier,
    onRemedioAdd: (String) -> Unit
) {
    var remedioNome by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = remedioNome,
        onValueChange = { remedioNome = it },
        label = { Text("Nome do remédio") },
        trailingIcon = {
            IconButton(
                onClick = {
                    onRemedioAdd(remedioNome)
                    remedioNome = "" // Limpa o campo após adicionar
                    focusManager.clearFocus() // Remove o foco da caixa de texto
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar")
            }
        }
    )
}

@Composable
fun RemediosList(
    modifier: Modifier = Modifier,
    remedios: List<String>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(16.dp)
            .border(
                width = 2.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        remedios.forEach { remedio ->
            Text(
                modifier = Modifier.padding(8.dp),
                text = remedio,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    AddRemedio(modifier = Modifier, onRemedioAdd = {})
}