package com.mokshith.gittest.screenComposabls

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mokshith.gittest.common.ViewUtils.Companion.baseOne
import com.mokshith.gittest.composableComponents.LoadingScreen
import com.mokshith.gittest.modelClasses.NycSchoolsModel
import com.mokshith.gittest.navigation.Screen
import com.mokshith.gittest.viewModelClasses.NycSchoolViewModel
import com.mokshith.gittest.viewModelClasses.ProductsViewModels

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NycSchoolsScreen(navController: NavHostController) {
    baseOne = false
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {

                    Text(
                        text = "Schools List",
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        baseOne = true
                        navController.navigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
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

        NycSchoolCard(navController, paddingIntent)
    }

}

@Composable
fun NycSchoolCard(
    navController: NavHostController,
    paddingIntent: PaddingValues,
    nycSchoolViewModel: NycSchoolViewModel = hiltViewModel()
) {
    val nycSchools by nycSchoolViewModel.stateNyc.collectAsState()
    val loading by nycSchoolViewModel.loading.collectAsState()

    if (loading){
        LoadingScreen()
    }else{
        LazyColumn(modifier = Modifier.padding(paddingIntent)) {
            items(nycSchools) { nycSchools: NycSchoolsModel ->
                SchoolListView(nycSchools)
            }
        }
    }


}

@Composable
fun SchoolListView(nycSchools: NycSchoolsModel) {

    Box(modifier = Modifier.padding(10.dp)) {

    }
}
