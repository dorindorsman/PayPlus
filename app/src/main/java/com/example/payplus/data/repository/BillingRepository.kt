package com.example.maccabi.data.repository

import android.util.Log
import com.example.payplus.data.models.Response
import com.example.payplus.domain.repository.BillingApi

class BillingRepository (
    private val api: BillingApi
) {
    companion object {
        const val TAG = "BillingRepository"
    }

    suspend fun getHeaders(): Response {
        Log.d(TAG, "getHeaders")

        val response = try {
            api.getHeaders()
        } catch (exception: Exception) {
            return Response.Error(exception)
        }
        return Response.Success(response)
    }

}