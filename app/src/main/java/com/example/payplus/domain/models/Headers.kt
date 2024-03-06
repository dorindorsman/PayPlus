package com.example.payplus.domain.models

import com.google.gson.annotations.SerializedName

data class Headers(
    @SerializedName("headers")
    var headers: List<BillingEntryHeader> = emptyList()
)
