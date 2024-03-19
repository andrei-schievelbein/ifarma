package br.com.noke.ifarma.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.automirrored.outlined.Message
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.noke.ifarma.screens.FarmaciaScreen
import br.com.noke.ifarma.screens.HomeScreen
import br.com.noke.ifarma.screens.PerfilScreen
import br.com.noke.ifarma.screens.RastrearScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            // Inclua ações aqui como ícones de pesquisa, etc.
            TopAppBar(
                title = { },
                modifier = modifier,
                actions = {

                    Row(

                        modifier = Modifier
                            .width(350.dp)
                    ) {
                        IconButton(onClick = { /* Ação */ }) {
                            Icon(
                                Icons.Filled.LocationOn,
                                contentDescription = "Localização",
                                tint = Color(0xFF59c606),
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(25.dp)
                            )
                        }


                        Text(
                            text = "Av. Lins de Vasconcelos,1264",
                            fontSize = 14.sp,
                            color = Color(0xFF4B61DD),
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.AutoMirrored.Outlined.Message,
                            contentDescription = "Pesquisar",
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                    }
                    Box(
                        modifier = Modifier.size(5.dp)
                            .background(Color.Red)
                            .clip(CircleShape)
                            .offset(x = (-30).dp)
                    ) {
                        Text(
                            text = "+1",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }


                }
//                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                containerColor = Color.Black // Opcional para transparência
//                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listofNavItem.forEach { navItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,

                        onClick = {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }

                        },
                        icon = {
                            var selected =
                                currentDestination?.hierarchy?.any { it.route == navItem.route } == true
                            Icon(

                                imageVector = if (selected) navItem.iconSelected else navItem.icon,
                                contentDescription = navItem.label,
                                modifier = Modifier
                                    .offset(y = (-10).dp)
                                    .height(40.dp)
                                    .width(40.dp),
                                tint = if (selected) Color(0xFF59c606) else Color.Gray
                            )
                        },
                        label = {
                            var selected =
                                currentDestination?.hierarchy?.any { it.route == navItem.route } == true
                            Text(
                                text = navItem.label,
                                fontSize = 14.sp,
                                color = if (selected) Color(0xFF59C606) else Color.Gray,
                                fontWeight = FontWeight.SemiBold
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(indicatorColor = Color.White)

                    )
                }
            }
        }


    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.name,
            modifier = modifier
                .padding(paddingValues)
        ) {
            composable(route = Screens.HomeScreen.name) {
                HomeScreen()
            }
            composable(route = Screens.FarmaciaScreen.name) {
                FarmaciaScreen()
            }
            composable(route = Screens.RastrearScreen.name) {
                RastrearScreen()
            }
            composable(route = Screens.PerfilScreen.name) {
                PerfilScreen()
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    modifier: Modifier = Modifier,
    // Você pode incluir ações aqui como ícones de pesquisa, etc.
) {
    TopAppBar(
        title = { Text(title) }, // Título da Top Bar
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent // Opcional para transparência
        )
    )
}