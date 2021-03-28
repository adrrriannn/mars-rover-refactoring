package com.adrrriannn.marsrover.context.position

sealed class Direction {
    object North: Direction()
    object South: Direction()
    object West: Direction()
    object East: Direction()
}
