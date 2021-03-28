package com.adrrriannn.marsrover.context.movement.infrastructure

import com.adrrriannn.marsrover.context.movement.domain.rotate.RotateLeftCommand
import com.adrrriannn.marsrover.context.movement.domain.rotate.RotateRightCommand
import com.adrrriannn.marsrover.context.movement.domain.shift.ShiftBackwardCommand
import com.adrrriannn.marsrover.context.movement.domain.shift.ShiftForwardCommand

object MovementCommandFactory {
    operator fun invoke(inputCommand: String) =
        when(inputCommand) {
            "f" -> ShiftForwardCommand
            "b" -> ShiftBackwardCommand
            "r" -> RotateRightCommand
            "l" -> RotateLeftCommand
            else -> throw RuntimeException("Invalid input command")
        }

}
