package com.example.relevelandroidproject.domain.use_case

import com.example.relevelandroidproject.domain.model.Coin
import com.example.relevelandroidproject.domain.repository.CoinRepository
import com.example.relevelandroidproject.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinListUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(page: String): Flow<ResponseState<List<Coin>>> = flow {
        try {
            emit(ResponseState.Loading())
            val coins = repository.getAllCoins(page).map {
                it.toCoin()
            }
            emit(ResponseState.Success(coins))
        } catch (e: HttpException) {
            emit(ResponseState.Error(e.localizedMessage ?: "An Unexpected Error"))
        } catch (e: IOException) {
            emit(ResponseState.Error("Internet Error"))
        }
    }
}