package com.example.payplus.domain.repository

import com.example.payplus.domain.models.BillingEntryHeader
import retrofit2.http.GET

interface BillingApi {
    @GET("/payment/billing/entry/headers/")
    suspend fun getBillingHeaders(): List<BillingEntryHeader>
}