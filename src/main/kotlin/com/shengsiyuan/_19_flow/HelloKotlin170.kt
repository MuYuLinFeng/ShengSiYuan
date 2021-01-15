package com.shengsiyuan._19_flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

/*
    Flow的组合
 */

fun main() = runBlocking {
    val flow1 = (1..5).asFlow()
    val flow2 = flowOf("one","two","three","four","five")

    flow1.zip(flow2){
        num: Int, trans: String ->
        "$num -> $trans"
    }
    println()
}