package com.adrrriannn.marsrover.adapter

import com.adrrriannn.marsrover.context.move.MoveBackwardCommand
import com.adrrriannn.marsrover.context.move.MoveForwardCommand
import java.io.PrintStream
import java.util.Scanner

class MarsRoverConsoleRunner(private val reader: Scanner,
                             private val printer: PrintStream) {

    operator fun invoke() {
        printer.println("Insert horizontal map size:")
        val sizex = reader.nextInt()
        printer.println("Insert vertical map size:")
        val sizey = reader.nextInt()
        printer.println("Insert horizontal initial rover position:")
        var roverx = reader.nextInt()
        printer.println("Insert vertical initial rover position:")
        var rovery = reader.nextInt()
        printer.println("Insert initial rover direction:")
        var roverz = reader.next() //n = north, e = east, w = west, s = south
//        do {
            printer.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
            val command = reader.next()

            if (command == "f") {
                val pair = MoveForwardCommand().move(roverz, rovery, sizey, roverx, sizex)
                roverx = pair.first
                rovery = pair.second
            }
            if (command == "b") {
                val pair = MoveBackwardCommand().move(roverz, rovery, sizey, roverx, sizex)
                roverx = pair.first
                rovery = pair.second
            }
            if (command == "l") {
                when (roverz) {
                    "n" -> {
                        roverz = "w"
                    }
                    "w" -> {
                        roverz = "s"
                    }
                    "s" -> {
                        roverz = "e"
                    }
                    "e" -> {
                        roverz = "n"
                    }
                }
            }
            if (command == "r") {
                when (roverz) {
                    "n" -> {
                        roverz = "e"
                    }
                    "e" -> {
                        roverz = "s"
                    }
                    "s" -> {
                        roverz = "w"
                    }
                    "w" -> {
                        roverz = "n"
                    }
                }
            }
            printer.println(String.format("Rover is at x:%d y:%d facing:%s", roverx, rovery, roverz))
//        } while (true)
    }

}
