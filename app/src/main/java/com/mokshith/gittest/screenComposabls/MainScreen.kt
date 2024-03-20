package com.mokshith.gittest.screenComposabls

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mokshith.gittest.modelClasses.Category
import com.mokshith.gittest.modelClasses.Product
import com.mokshith.gittest.viewModelClasses.ProductsViewModels

@Composable
fun MainScreen(navController: NavHostController) {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Red
    ) {
        MainScreenData(navController)
    }
}

@Composable
fun MainScreenData(
    navController: NavHostController,
    productsViewModels: ProductsViewModels = hiltViewModel()
) {
    val state by productsViewModels.stateCa.collectAsState()
    LazyColumn {
        items(state){ item: Category ->
            ProductImageCard(item.strCategory)
        }
    }

}

@Composable
fun ProductImageCard(title: String) {
    Text(text = title)
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen(navController = rememberNavController())
}
