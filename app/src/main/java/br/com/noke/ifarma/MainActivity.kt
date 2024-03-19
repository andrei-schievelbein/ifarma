package br.com.noke.ifarma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.noke.ifarma.navigation.AppNavigation
import br.com.noke.ifarma.ui.theme.IfarmaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IfarmaTheme {
            AppNavigation()
            }
        }
    }
}

