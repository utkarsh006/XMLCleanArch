package com.example.relevelandroidproject.presentation.Coin

import com.example.relevelandroidproject.domain.model.CoinDetail

data class CoinState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)