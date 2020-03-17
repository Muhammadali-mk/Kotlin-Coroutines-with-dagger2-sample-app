package com.mk.recyclerviewtask.utils

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

@Suppress("EXPERIMENTAL_API_USAGE")
suspend fun <T> Flow<Result<T>>.collect(
    onStart: () -> Unit,
    onSuccess: (T) -> Unit,
    onFailure: (Throwable) -> Unit
) = onStart { onStart() }.collect { it.onSuccess(onSuccess).onFailure(onFailure) }

@ExperimentalCoroutinesApi
fun <T> Flow<T>.flatMapResult(): Flow<Result<T>> =
    map { Result.success(it) }.catch { emit(Result.failure(it)) }