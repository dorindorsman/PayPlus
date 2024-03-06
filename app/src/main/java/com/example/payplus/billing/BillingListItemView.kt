package com.example.payplus.billing

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.payplus.R
import com.example.payplus.domain.models.BillingEntryHeader
import com.example.payplus.ui.DarkGrayColor
import com.example.payplus.ui.GreenColor
import com.example.payplus.ui.LightGrayColor
import com.example.payplus.ui.ManualColor
import com.example.payplus.ui.PosColor
import com.example.payplus.ui.TerminalColor
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun BillingListItemView(listItem: BillingEntryHeader) {
    Row(
        modifier = Modifier
            .border(BorderStroke(0.5.dp, LightGrayColor))
            .fillMaxSize()
            .clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(getSourceBackgroundColorIcon(listItem.source))
                .height(50.dp)
                .width(50.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = getSourceIcon(listItem.source),
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp),
                contentDescription = "",
                tint = Color.White
            )
        }

        Column(
            modifier = Modifier
                .weight(0.4f)
                .padding(start = 8.dp),
        ) {
            Text(
                modifier = Modifier,
                text = listItem.price.toString(),
                style = MaterialTheme.typography.h6,
                color = DarkGrayColor
            )
            Row(
                modifier = Modifier
                    .clickable { },
            ) {
                Text(
                    modifier = Modifier.padding(end = 5.dp),
                    text = getDateTime(listItem.created),
                    style = MaterialTheme.typography.body2,
                    color = LightGrayColor
                )
                if (showIcon(listItem.cardType)) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .background(GreenColor)
                            .size(15.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_upload),
                            modifier = Modifier,
                            contentDescription = "",
                            tint = Color.White,
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .clickable { },
        ){
            Icon(
                imageVector = getCurrencyIcon(listItem.currencyCode),
                modifier = Modifier
                    .padding(5.dp)
                    .height(30.dp)
                    .width(30.dp),
                contentDescription = "",
                tint = Color.Black
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow),
                modifier = Modifier
                    .padding(5.dp)
                    .height(30.dp)
                    .width(30.dp),
                contentDescription = "",
                tint = Color.Black
            )
        }
    }
}

fun showIcon(cardType: String?): Boolean {
    return cardType?.lowercase().equals(CardType.MASTERCARD.name.lowercase())
}

fun getDateTime(created: Long?): String {
    val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    return sdf.format(created).toString()
}

@Composable
fun getSourceIcon(source: String?): ImageVector {
    return when (source?.lowercase()) {
        Source.TERMINAL.name.lowercase() -> ImageVector.vectorResource(id = R.drawable.ic_attendant)
        Source.POS.name.lowercase() -> ImageVector.vectorResource(id = R.drawable.ic_pos)
        Source.MANUAL.name.lowercase() -> ImageVector.vectorResource(id = R.drawable.ic_card)
        else -> ImageVector.vectorResource(id = R.drawable.ic_attendant)
    }
}

@Composable
fun getSourceBackgroundColorIcon(source: String?): Color {
    return when (source?.lowercase()) {
        Source.TERMINAL.name.lowercase() -> TerminalColor
        Source.POS.name.lowercase() -> PosColor
        Source.MANUAL.name.lowercase() -> ManualColor
        else -> TerminalColor
    }
}

@Composable
fun getCurrencyIcon(currencyCode: String?): ImageVector {
    return when (currencyCode) {
        CurrencyCode.ILS.name -> ImageVector.vectorResource(id = R.drawable.ic_ils)
        CurrencyCode.USD.name -> ImageVector.vectorResource(id = R.drawable.ic_dollar)
        else -> ImageVector.vectorResource(id = R.drawable.ic_ils)
    }

}


