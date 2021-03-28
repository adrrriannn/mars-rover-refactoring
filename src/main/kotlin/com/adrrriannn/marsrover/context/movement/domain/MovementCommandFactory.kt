package com.adrrriannn.marsrover.context.movement.domain

import com.adrrriannn.marsrover.context.movement.domain.rotate.RotateLeftCommand
import com.adrrriannn.marsrover.context.movement.domain.rotate.RotateRightCommand
import com.adrrriannn.marsrover.context.movement.domain.shift.ShiftBackwardCommand
import com.adrrriannn.marsrover.context.movement.domain.shift.ShiftForwardCommand

object MovementCommandFactory {
    operator fun invoke(movement: Movement) =
        when(movement) {
            Movement.ShiftForward -> ShiftForwardCommand
            Movement.ShiftBackward -> ShiftBackwardCommand
            Movement.RotateRight -> RotateRightCommand
            Movement.RotateLeft -> RotateLeftCommand
            else -> throw RuntimeException("Invalid input command")
        }
}
