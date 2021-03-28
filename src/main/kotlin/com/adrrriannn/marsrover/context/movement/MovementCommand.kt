package com.adrrriannn.marsrover.context.movement

import com.adrrriannn.marsrover.context.planet.Planet
import com.adrrriannn.marsrover.context.position.Position

interface MovementCommand {
    operator fun invoke(planet: Planet, position: Position): Position
}
