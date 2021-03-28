package com.adrrriannn.marsrover

import java.io.PrintStream
import java.util.Scanner
import javax.swing.Spring.height




class MarsRover(private val reader: Scanner,
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
                if (roverz == "n") {
                    rovery = (rovery + 1) % sizey
                }
                if (roverz == "w") {
                    roverx = if (roverx > 0) roverx - 1 else sizex - 1
                }
                if (roverz == "s") {
                    rovery =  if (rovery > 0) rovery - 1 else sizey - 1
                }
                if (roverz == "e") {
                    roverx = (roverx + 1) % sizex
                }
            }
            if (command == "b") {
                if (roverz == "n") {
                    rovery = if (rovery > 0) rovery - 1 else sizey - 1
                }
                if (roverz == "w") {
                    roverx = (roverx + 1) % sizex
                }
                if (roverz == "s") {
                    rovery = (rovery + 1) % sizey
                }
                if (roverz == "e") {
                    roverx = if (roverx > 0) roverx - 1 else sizex - 1
                }
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
