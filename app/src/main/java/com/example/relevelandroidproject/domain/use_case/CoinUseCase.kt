package com.example.relevelandroidproject.domain.use_case

import com.example.relevelandroidproject.domain.model.CoinDetail
import com.example.relevelandroidproject.domain.repository.CoinRepository
import com.example.relevelandroidproject.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(id: String): Flow<ResponseState<CoinDetail>> = flow {
        try {
            emit(ResponseState.Loading())
            val coin = repository.getCoinById(id).toCoinDetail()
            emit(ResponseState.Success(coin))
        } catch (e: HttpException) {
            emit(ResponseState.Error(e.localizedMessage ?: "An Unexpected Error"))
        } catch (e: IOException) {
            emit(ResponseState.Error("Internet Error"))
        }
    }
}