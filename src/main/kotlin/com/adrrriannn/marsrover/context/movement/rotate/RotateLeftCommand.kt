package com.adrrriannn.marsrover.context.movement.rotate

import com.adrrriannn.marsrover.context.movement.MovementCommand
import com.adrrriannn.marsrover.context.planet.Planet
import com.adrrriannn.marsrover.context.position.Direction
import com.adrrriannn.marsrover.context.position.Position

object RotateLeftCommand: MovementCommand {

    override fun invoke(planet: Planet, position: Position): Position {
        val newDirection = when (position.direction) {
            Direction.North -> Direction.West
            Direction.West  -> Direction.South
            Direction.South -> Direction.East
            Direction.East  -> Direction.North
        }
        return position.withDirection(newDirection)
    }
}
