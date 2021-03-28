package com.adrrriannn.marsrover.context.vehicle.rover.behaviour

import com.adrrriannn.marsrover.context.movement.domain.Movement
import com.adrrriannn.marsrover.context.planet.Mars
import com.adrrriannn.marsrover.context.position.Coordinates
import com.adrrriannn.marsrover.context.position.Direction
import com.adrrriannn.marsrover.context.vehicle.rover.Rover
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RoverShould {

    @Test
    fun `move`() {

        val initialCoordinates = Coordinates(1, 1)
        val direction = Direction.North
        val planet = Mars(5, 5)
        val rover = Rover(initialCoordinates, direction, planet)

        val updatedRover = rover.move(Movement.ShiftForward)
        val currentPosition = updatedRover.currentPosition()

        assertThat(currentPosition.coordinates.y).isEqualTo(initialCoordinates.y + 1)
    }
}
