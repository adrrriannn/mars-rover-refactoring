package com.adrrriannn.marsrover.adapter

import com.adrrriannn.marsrover.context.movement.shift.ShiftBackwardCommand
import com.adrrriannn.marsrover.context.movement.shift.ShiftForwardCommand
import com.adrrriannn.marsrover.context.movement.rotate.RotateLeftCommand
import com.adrrriannn.marsrover.context.movement.rotate.RotateRightCommand
import com.adrrriannn.marsrover.context.planet.Mars
import com.adrrriannn.marsrover.context.position.Coordinates
import com.adrrriannn.marsrover.context.position.Direction
import com.adrrriannn.marsrover.context.position.Position
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
        val initialPosition = Position(coordinates, direction)
        var finalPosition:Position? = null
//        do {
            printer.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
            val inputCommand = reader.next()

            if (inputCommand == "f") {
                finalPosition = ShiftForwardCommand(planet, initialPosition)
            }
            if (inputCommand == "b") {
                finalPosition = ShiftBackwardCommand(planet, initialPosition)
            }
            if (inputCommand == "l") {
                finalPosition = RotateLeftCommand(planet, initialPosition)
            }
            if (inputCommand == "r") {
                finalPosition = RotateRightCommand(planet, initialPosition)
            }
            printer.println(String.format("Rover is at x:%d y:%d facing:%s", finalPosition!!.coordinates.x, finalPosition!!.coordinates.y, finalPosition!!.direction.toConsoleOutput()))
//        } while (true)
    }

    private fun mapDirection(roverInitialDirection: String) =
        when(roverInitialDirection) {
            "n" -> Direction.North
            "s" -> Direction.South
            "e" -> Direction.East
            "w" -> Direction.West
            else -> throw RuntimeException("Invalid direction input")
        }

}

private fun Direction.toConsoleOutput() =
    when(this) {
        Direction.North -> "n"
        Direction.South -> "s"
        Direction.West  -> "w"
        Direction.East  -> "e"
    }
