package com.example.maccabi.domain.models

import com.example.payplus.domain.models.BillingEntryHeader
import com.google.gson.annotations.SerializedName

data class Shop(
    @SerializedName("products")
    var products: List<BillingEntryHeader> = emptyList()
)
