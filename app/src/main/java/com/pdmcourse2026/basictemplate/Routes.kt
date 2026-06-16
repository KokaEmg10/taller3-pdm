package com.pdmcourse2026.basictemplate

sealed class Screen(val route: String) {
  object Vote : Screen("vote_screen")
  object Results : Screen("results_screen")
}