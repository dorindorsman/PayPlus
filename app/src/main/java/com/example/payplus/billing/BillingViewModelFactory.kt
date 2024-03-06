package com.example.payplus.billing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.maccabi.data.repository.BillingRepository
import com.example.payplus.domain.repository.BillingApi
import retrofit2.converter.gson.GsonConverterFactory

class BillingViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val retrofitBuilder = retrofit2.Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.1.127:8030/") // Fixme
            .build()
            .create(BillingApi::class.java)

        return BillingViewModel(
            BillingRepository(retrofitBuilder)
        ) as T
    }
}





