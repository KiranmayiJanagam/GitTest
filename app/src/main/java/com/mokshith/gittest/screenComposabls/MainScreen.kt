package com.mokshith.gittest.screenComposabls

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mokshith.gittest.common.ViewUtils
import com.mokshith.gittest.composableComponents.LoadingScreen
import com.mokshith.gittest.modelClasses.Category
import com.mokshith.gittest.navigation.Screen
import com.mokshith.gittest.viewModelClasses.ProductsViewModels

@Composable
fun MainScreen(navController: NavHostController) {

    ViewUtils.baseOne = true
    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        MainScreenData(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenData(
    navController: NavHostController,
    productsViewModels: ProductsViewModels = hiltViewModel()
) {
    val state by productsViewModels.state1.collectAsState()
    val loading by productsViewModels.loading.collectAsState()
    if (loading) {
        LoadingScreen()
    } else {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {

                        Text(
                            text = "Categories List",
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { navController.navigate(Screen.NycSchoolScreen.route) }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            },
        ) { paddingIntent ->
            ProductImageCard(state.categories, navController, paddingIntent)
        }
    }
}

@Composable
fun ProductImageCard(
    categories: List<Category>?,
    navController: NavHostController,
    paddingIntent: PaddingValues
) {
    Column(
        modifier = Modifier.padding(paddingIntent)
    ) {
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
                        val image = categories[it].strCategoryThumb
                        Text(
                            text = categories[it].strCategory,
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable {
                                    navController.currentBackStackEntry?.savedStateHandle?.apply {
                                        set("category", categories[it])
                                    }

                                    navController.navigate(Screen.DetailsScreen.route)
                                }
                        )
                    }
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
