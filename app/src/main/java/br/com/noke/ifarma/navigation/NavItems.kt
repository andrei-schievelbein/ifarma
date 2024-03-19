package br.com.noke.ifarma.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adb
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhotoAlbum
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PhotoAlbum
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String,
    val iconSelected: ImageVector
)
val listofNavItem : List<NavItem> = listOf(
    NavItem(
        label = "Home",
        icon = Icons.Outlined.Home,
        iconSelected = Icons.Filled.Home,
        route = Screens.HomeScreen.name

    ),
    NavItem(
        label = "Farmacia",
        icon = Icons.Outlined.PhotoAlbum,
        iconSelected = Icons.Filled.PhotoAlbum,
        route = Screens.FarmaciaScreen.name
    ),
    NavItem(
        label = "Rastrear",
        icon = Icons.Outlined.LocationOn,
        iconSelected = Icons.Filled.LocationOn,
        route = Screens.RastrearScreen.name
    ),
    NavItem(
        label = "Perfil",
        icon = Icons.Outlined.Person,
        iconSelected = Icons.Filled.Person,
        route = Screens.PerfilScreen.name
    )
)