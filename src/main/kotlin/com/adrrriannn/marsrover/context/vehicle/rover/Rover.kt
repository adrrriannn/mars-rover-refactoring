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
    companion object {
        private val allowedMovements = listOf(Movement.ShiftForward,
                                              Movement.ShiftBackward,
                                              Movement.RotateRight,
                                              Movement.RotateLeft)
    }

    fun currentPosition() = Position(coordinates, direction)

    fun move(movement: Movement): Rover {
        guardMovementIsAllowed(movement)
        val newPosition = MovementCommandFactory(movement)(planet, currentPosition())
        return updatePosition(newPosition)
    }

    private fun guardMovementIsAllowed(movement: Movement) {
        if(!allowedMovements.contains(movement)) {
            throw RuntimeException("Movement not allowed")
        }
    }

    private fun updatePosition(newPosition: Position) = this.copy(coordinates = newPosition.coordinates,
                                                                  direction = newPosition.direction)
}
