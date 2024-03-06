package com.example.payplus

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.payplus.MainPage.Billing
import com.example.payplus.MainPage.BillingItem
import com.example.payplus.billing.BillingView
import com.example.payplus.billing.BillingViewModelFactory
import com.example.payplus.billing_item.BillingItemView
import com.example.payplus.billing_item.BillingItemViewModel


object MainPage {
    const val Billing = "Billing"
    const val BillingItem = "BillingItem"
}

@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier,
) {

    val appContext = LocalContext.current.applicationContext
    NavHost(navController, startDestination = Billing, modifier = modifier) {
        composable(route = Billing) {
            BillingView(
                viewModel(
                    factory = BillingViewModelFactory()
                )
            )
        }

        composable(route = BillingItem) {
            BillingItemView(
                BillingItemViewModel(),
                navController.popBackStack()
            )
        }
    }

}