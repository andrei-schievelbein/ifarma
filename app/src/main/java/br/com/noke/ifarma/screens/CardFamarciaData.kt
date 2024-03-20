package br.com.noke.ifarma.screens

import br.com.noke.ifarma.R

data class CardFamarciaData(val imagem: Int,val remedios: List<String>, val situacao: String, val valor: Double)


val listaRemedios = listOf(
    "Aspirina Prevent 100mg 30 Com...",
    "Advil 400mg - 8 cápsulas",
    "Repelente Off Kids loção",
    "Sal de frutas Eno - 2 Envelopes"
)
val valores = listOf(
    CardFamarciaData(R.drawable.drogaraia, listaRemedios,"Concluído",38.0),
    CardFamarciaData(R.drawable.drogariabrasil,listaRemedios,"Concluído",42.5),
    CardFamarciaData(R.drawable.drogariapacheco,listaRemedios,"Requer atenção",44.0),
    CardFamarciaData(R.drawable.drogariasaopaulo,listaRemedios,"Em análise, aguarde",0.0),
    CardFamarciaData(R.drawable.drogariaonofre,listaRemedios,"Em análise, aguarde",0.0),
    CardFamarciaData(R.drawable.drogariaabc,listaRemedios,"Em análise, aguarde",0.0))

