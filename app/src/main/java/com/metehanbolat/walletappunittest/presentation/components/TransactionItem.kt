package com.metehanbolat.walletappunittest.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.metehanbolat.walletappunittest.util.formatToPrice
import java.util.Locale

@Composable
fun TransactionItem(
    color: Color,
    description: String,
    value: Float,
    date: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = description, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            Text(text = date, fontWeight = FontWeight.Normal, fontSize = 13.sp)
        }
        Text(
            text = value.formatToPrice(Locale.getDefault(), true),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = color
        )
    }
}