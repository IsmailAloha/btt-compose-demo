package com.bluetriangle.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bluetriangle.composedemo.ui.screens.ProductsScreen
import com.bluetriangle.composedemo.ui.theme.BlueTriangleComposeDemoTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlueTriangleComposeDemoTheme {
                Scaffold(topBar = { TopAppBar(title = { Text(text = "Products") }) }) {
                    HomeContent(it)
                }
            }
        }
    }

    @Composable
    private fun HomeContent(paddingValues: PaddingValues) {
        val items = listOf(
            Pair("Products", Icons.Filled.Menu),
            Pair("Cart", Icons.Filled.ShoppingCart),
            Pair("Settings", Icons.Filled.Settings)
        )
        val selectedItem = remember {
            mutableIntStateOf(0)
        }
        Column(Modifier.padding(paddingValues)) {
            ProductsScreen()
            BottomNavigation {
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Menu, contentDescription = null) },
                        label = { Text(item.first) },
                        selected = selectedItem.value == index,
                        onClick = { selectedItem.value = index }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    BlueTriangleComposeDemoTheme {
        Greeting2("Android")
    }
}