package com.adrrriannn.marsrover.context.movement.rotate

import com.adrrriannn.marsrover.context.movement.MovementCommand
import com.adrrriannn.marsrover.context.planet.Planet
import com.adrrriannn.marsrover.context.position.Direction
import com.adrrriannn.marsrover.context.position.Position

object RotateRightCommand: MovementCommand {
    override fun invoke(planet: Planet, position: Position): Position {
        val newDirection = when (position.direction) {
            Direction.North -> Direction.East
            Direction.West  -> Direction.North
            Direction.South -> Direction.West
            Direction.East  -> Direction.South
        }
        return position.withDirection(newDirection)
    }
}
