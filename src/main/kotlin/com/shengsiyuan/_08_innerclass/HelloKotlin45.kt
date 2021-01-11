package com.shengsiyuan._08_innerclass

enum class Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER
}

enum class Season2(val temperature: Int) {
    SPRING(10),
    SUMMER(30),
    AUTUMN(20),
    WINTER(-10)
}

//枚举中声明方法
enum class Season3 {
    SPRING {
        override fun getSeason(): Season3 {
            return SPRING
        }
    },
    SUMMER {
        override fun getSeason() = SUMMER
    },
    AUTUMN {
        override fun getSeason() = AUTUMN
    },
    WINTER {
        override fun getSeason() = WINTER
    };

    abstract fun getSeason(): Season3
}

fun main() {
    val seasons = Season.values()
    seasons.forEach { println(it) }
    println("-------------")
    val season = Season.valueOf("SPRING")
    println(season)
}