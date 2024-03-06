package com.example.payplus.billing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun BillingView(
    viewModel: BillingViewModel
) {
    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
        LazyColumn(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(5.dp)),
        ) {
            items(viewModel.billingHeaders.size) { i ->
                BillingListItemView(listItem = viewModel.billingHeaders[i])
            }
        }

    }
}