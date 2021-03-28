package com.adrrriannn.marsrover.context.position

data class Position(val coordinates: Coordinates,
                    val direction: Direction) {
    fun withDirection(newDirection: Direction) = copy(direction = newDirection)
    fun withCoordinates(newCoordinates: Coordinates) = copy(coordinates = newCoordinates)
}
