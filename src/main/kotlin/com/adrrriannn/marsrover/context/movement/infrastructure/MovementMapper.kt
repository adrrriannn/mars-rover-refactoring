package com.adrrriannn.marsrover.context.movement.infrastructure

import com.adrrriannn.marsrover.context.movement.domain.Movement


object MovementMapper {
    operator fun invoke(inputCommand: String) =
        when(inputCommand) {
            "f" -> Movement.ShiftForward
            "b" -> Movement.ShiftBackward
            "r" -> Movement.RotateRight
            "l" -> Movement.RotateLeft
            else -> throw RuntimeException("Invalid input command")
        }

}
