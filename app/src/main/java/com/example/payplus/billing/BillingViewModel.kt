package com.example.payplus.billing

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maccabi.data.repository.BillingRepository
import com.example.payplus.data.models.Response
import com.example.payplus.domain.models.BillingEntryHeader
import kotlinx.coroutines.launch

class BillingViewModel(
    private val billingRepository: BillingRepository
) : ViewModel() {

    companion object {
        const val TAG = "BillingViewModel"
    }

    init {
        getBillingHeaders()
    }


    private var billingHeaders: List<BillingEntryHeader> by mutableStateOf(
        emptyList()
    )

//    fun handle(event: CategoriesEvent) {
//        when (event) {
//            CategoriesEvent.GetShop -> getShop()
//        }
//    }

    private fun getBillingHeaders() = viewModelScope.launch {
        Log.d(TAG, "getBillingHeaders")
        billingRepository.getBillingHeaders().also { response ->
            if (response is Response.Success) {
                Log.d(TAG, "${response.data}")
                billingHeaders = response.data
                Log.d(TAG, "dorin $billingHeaders")
            } else if (response is Response.Error) {
                response.apply {
                    Log.e(TAG, "${error.message}")
                }
            }
        }
    }

//    private fun orderShop() {
//        Log.d(TAG, "orderShop")
//        shopCategories = shop.products.groupBy {
//            it.category
//        }.toList()
//    }

}