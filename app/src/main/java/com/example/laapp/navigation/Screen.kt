package com.kentsanoff.landapp.navigation

sealed class Screen(val route: String) {
    object Start : Screen("start")
    object Overview : Screen("overview")
    object Detail : Screen("detail")
    object Form : Screen("form")
    object Settings : Screen("settings")
    object Upload : Screen("upload")
}
