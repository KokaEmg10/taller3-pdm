package com.pdmcourse2026.basictemplate

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdmcourse2026.basictemplate.data.AppProvider
import com.pdmcourse2026.basictemplate.screens.home.ResultsScreen
import com.pdmcourse2026.basictemplate.screens.home.VoteScreen
import com.pdmcourse2026.basictemplate.ui.viewmodel.RankViewModel

@Composable
fun RankeUCA_App() {
  val navController = rememberNavController()
  val rankViewModel: RankViewModel = viewModel()

  NavHost(
    navController = navController,
    startDestination = Screen.Vote.route
  ) {
    composable(Screen.Vote.route) {
      VoteScreen(
        viewModel = rankViewModel,
        onNavigateToResults = { navController.navigate(Screen.Results.route) }
      )
    }
    composable(Screen.Results.route) {
      ResultsScreen(
        viewModel = rankViewModel,
        onNavigateToVote = { navController.navigate(Screen.Vote.route) }
      )
    }
  }
}

class RankeUcaApplication : Application() {
    val appProvider by lazy { AppProvider(this) }
}