package com.adrrriannn.marsrover.context.movement.domain.shift

import com.adrrriannn.marsrover.context.movement.domain.MovementCommand
import com.adrrriannn.marsrover.context.planet.Planet
import com.adrrriannn.marsrover.context.position.Coordinates
import com.adrrriannn.marsrover.context.position.Direction
import com.adrrriannn.marsrover.context.position.Position

object ShiftBackwardCommand: MovementCommand {
    fun move(roverz: String?, rovery: Int, sizey: Int, roverx: Int, sizex: Int): Coordinates {
        var rovery1 = rovery
        var roverx1 = roverx
        if (roverz == "n") {
            rovery1 = if (rovery1 > 0) rovery1 - 1 else sizey - 1
        }
        if (roverz == "w") {
            roverx1 = (roverx1 + 1) % sizex
        }
        if (roverz == "s") {
            rovery1 = (rovery1 + 1) % sizey
        }
        if (roverz == "e") {
            roverx1 = if (roverx1 > 0) roverx1 - 1 else sizex - 1
        }
        return Coordinates(roverx1, rovery1)
    }

    override fun invoke(planet: Planet, position: Position): Position {
        var positionY = position.coordinates.y
        var positionX = position.coordinates.x

        when (position.direction) {
            Direction.North -> positionY = if (positionY > 0) positionY - 1 else planet.verticalSize - 1
            Direction.West  -> positionX = (positionX + 1) % planet.horizontalSize
            Direction.South -> positionY = (positionY + 1) % planet.verticalSize
            Direction.East  -> positionX = if (positionX > 0) positionX - 1 else planet.horizontalSize - 1
        }

        val newCoordinates = Coordinates(positionX, positionY)
        return position.withCoordinates(newCoordinates)
    }
}
