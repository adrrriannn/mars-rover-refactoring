package com.adrrriannn.marsrover.adapter

import com.adrrriannn.marsrover.context.movement.infrastructure.MovementMapper
import com.adrrriannn.marsrover.context.planet.Mars
import com.adrrriannn.marsrover.context.position.Coordinates
import com.adrrriannn.marsrover.context.position.Direction
import com.adrrriannn.marsrover.context.vehicle.rover.Rover
import java.io.PrintStream
import java.lang.RuntimeException
import java.util.Scanner

class MarsRoverConsoleRunner(private val reader: Scanner,
                             private val printer: PrintStream) {

    operator fun invoke() {
        printer.println("Insert horizontal map size:")
        val mapXSize = reader.nextInt()
        printer.println("Insert vertical map size:")
        val mapYSize = reader.nextInt()
        printer.println("Insert horizontal initial rover position:")
        var roverInitialPositionX = reader.nextInt()
        printer.println("Insert vertical initial rover position:")
        var roverInitialPositionY = reader.nextInt()
        printer.println("Insert initial rover direction:")
        var roverInitialDirection = reader.next() //n = north, e = east, w = west, s = south

        val planet = Mars(mapXSize, mapYSize)

        val coordinates = Coordinates(roverInitialPositionX, roverInitialPositionY)
        val direction = mapDirection(roverInitialDirection)

        var rover = Rover(coordinates, direction, planet)
//        do {
            printer.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
            val inputCommand = reader.next()

            val movement = MovementMapper(inputCommand)

            rover = rover.move(movement)

            printer.println(String.format("Rover is at x:%d y:%d facing:%s", rover.currentPosition().coordinates.x, rover.currentPosition().coordinates.y, rover.currentPosition().direction.toConsoleOutput()))
//        } while (true)
    }


}

private fun mapDirection(roverInitialDirection: String) =
    when(roverInitialDirection) {
        "n" -> Direction.North
        "s" -> Direction.South
        "e" -> Direction.East
        "w" -> Direction.West
        else -> throw RuntimeException("Invalid direction input")
    }

private fun Direction.toConsoleOutput() =
    when(this) {
        Direction.North -> "n"
        Direction.South -> "s"
        Direction.West  -> "w"
        Direction.East  -> "e"
    }
