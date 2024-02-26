package com.example.relevelandroidproject.data.repository

import com.example.relevelandroidproject.data.data_source.dto.CoinDetailDTO.CoinDetailDto
import com.example.relevelandroidproject.data.data_source.CoinGeckoApi
import com.example.relevelandroidproject.data.data_source.dto.CoinListDTO.CoinListDtoItem
import com.example.relevelandroidproject.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinGeckoApi
) : CoinRepository {
    override suspend fun getAllCoins(page: String): List<CoinListDtoItem> {
        return api.getAllCoins(page)
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
        return api.getCoinById(id)
    }
}