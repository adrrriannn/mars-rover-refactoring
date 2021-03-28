package com.adrrriannn.marsrover.context.vehicle.rover

import com.adrrriannn.marsrover.context.movement.domain.Movement
import com.adrrriannn.marsrover.context.movement.domain.MovementCommandFactory
import com.adrrriannn.marsrover.context.planet.Planet
import com.adrrriannn.marsrover.context.position.Coordinates
import com.adrrriannn.marsrover.context.position.Direction
import com.adrrriannn.marsrover.context.position.Position

data class Rover(private val coordinates: Coordinates,
                 private val direction: Direction,
                 private val planet: Planet) {
    fun currentPosition() = Position(coordinates, direction)

    fun move(movement: Movement): Rover {
        val newPosition = MovementCommandFactory(movement)(planet, currentPosition())
        return updatePosition(newPosition)
    }

    private fun updatePosition(newPosition: Position) = this.copy(coordinates = newPosition.coordinates,
                                                                  direction = newPosition.direction)
}
