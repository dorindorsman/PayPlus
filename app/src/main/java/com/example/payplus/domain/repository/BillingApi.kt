package com.example.payplus.domain.repository

import com.example.payplus.domain.models.Headers
import retrofit2.http.POST

interface BillingApi {
    //http://192.168.1.127:8030/payment/billing/entry/headers
    @POST("payment/billing/entry/headers")
    suspend fun getHeaders(): Headers
}