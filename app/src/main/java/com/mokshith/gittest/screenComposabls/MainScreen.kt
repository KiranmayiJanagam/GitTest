package com.mokshith.gittest.screenComposabls

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mokshith.gittest.modelClasses.Category
import com.mokshith.gittest.navigation.Screen
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
    val state by productsViewModels.state1.collectAsState()

    if (state.equals(null)) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    } else {
        ProductImageCard(state.categories, navController)
    }

}

@Composable
fun ProductImageCard(categories: List<Category>?, navController: NavHostController) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        if (categories != null) {
            items(categories.size) {
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(
                        text = categories[it].strCategory,
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable {
                                navController.navigate(Screen.DetailsScreen.route + "/ ${categories[it].strCategoryDescription}/ ${categories[it].strCategoryThumb}")
                            }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen(navController = rememberNavController())
}
