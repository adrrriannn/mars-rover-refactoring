package com.adrrriannn.marsrover.context.movement.domain

sealed class Movement {
    object ShiftForward: Movement()
    object ShiftBackward: Movement()
    object RotateRight: Movement()
    object RotateLeft: Movement()
}
