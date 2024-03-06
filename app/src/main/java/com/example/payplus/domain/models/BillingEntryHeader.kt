package com.example.payplus.domain.models

import com.google.gson.annotations.SerializedName

data class BillingEntryHeader(
    @SerializedName("id")
    var id: Long? = null,

    @SerializedName("price")
    var price: Double? = null,

    @SerializedName("created")
    var created: Long? = null,

    @SerializedName("entryNumber")
    var entryNumber: Int? = null,

    @SerializedName("totalEntryCount")
    var totalEntryCount: Int? = null,

    @SerializedName("source")
    var source: String? = null,

    @SerializedName("currencyCode")
    var currencyCode: String? = null,

    @SerializedName("cardType")
    var cardType: String? = null
)
