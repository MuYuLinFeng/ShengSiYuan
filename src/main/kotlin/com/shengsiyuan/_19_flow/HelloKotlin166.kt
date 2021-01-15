package com.shengsiyuan._19_flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

private fun myMethod(): Flow<Int> = flow {
    log("started")
    withContext(Dispatchers.Default) {
        for (i in 1..4) {
            log("withContext")
            Thread.sleep(100)
            emit(i)
        }
    }
}

fun main() = runBlocking {
    myMethod().flowOn(Dispatchers.Default).collect {
        log("collect $it")
    }
    log("runBlocking")
}