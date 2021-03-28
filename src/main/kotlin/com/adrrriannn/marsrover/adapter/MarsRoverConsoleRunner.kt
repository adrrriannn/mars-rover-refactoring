package com.adrrriannn.marsrover.adapter

import com.adrrriannn.marsrover.context.move.MoveBackwardCommand
import com.adrrriannn.marsrover.context.move.MoveForwardCommand
import java.io.PrintStream
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
        var roverInitialPosition = reader.next() //n = north, e = east, w = west, s = south
//        do {
            printer.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
            val inputCommand = reader.next()

            if (inputCommand == "f") {
                val coordinates = MoveForwardCommand().move(roverInitialPosition, roverInitialPositionY, mapYSize, roverInitialPositionX, mapXSize)
                roverInitialPositionX = coordinates.x
                roverInitialPositionY = coordinates.y
            }
            if (inputCommand == "b") {
                val coordinates = MoveBackwardCommand().move(roverInitialPosition, roverInitialPositionY, mapYSize, roverInitialPositionX, mapXSize)
                roverInitialPositionX = coordinates.x
                roverInitialPositionY = coordinates.y
            }
            if (inputCommand == "l") {
                when (roverInitialPosition) {
                    "n" -> {
                        roverInitialPosition = "w"
                    }
                    "w" -> {
                        roverInitialPosition = "s"
                    }
                    "s" -> {
                        roverInitialPosition = "e"
                    }
                    "e" -> {
                        roverInitialPosition = "n"
                    }
                }
            }
            if (inputCommand == "r") {
                when (roverInitialPosition) {
                    "n" -> {
                        roverInitialPosition = "e"
                    }
                    "e" -> {
                        roverInitialPosition = "s"
                    }
                    "s" -> {
                        roverInitialPosition = "w"
                    }
                    "w" -> {
                        roverInitialPosition = "n"
                    }
                }
            }
            printer.println(String.format("Rover is at x:%d y:%d facing:%s", roverInitialPositionX, roverInitialPositionY, roverInitialPosition))
//        } while (true)
    }

}
