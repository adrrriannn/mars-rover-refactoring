package com.adrrriannn.marsrover.context.position

data class Coordinates(val x: Int, val y: Int) {
    fun withX(x: Int) = copy(x = x)
    fun withY(y: Int) = copy(y = y)
}
