package com.example.payplus.data.models

import com.example.payplus.domain.models.BillingEntryHeader


sealed class Response {
    data class Success(val data: List<BillingEntryHeader>) : Response()
    data class Error(val error: Throwable) : Response()
}