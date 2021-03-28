package com.adrrriannn.marsrover.context.move

import com.adrrriannn.marsrover.context.position.Coordinates

class MoveForwardCommand {
    fun move(roverz: String?, rovery: Int, sizey: Int, roverx: Int, sizex: Int): Coordinates {
        var rovery1 = rovery
        var roverx1 = roverx
        if (roverz == "n") {
            rovery1 = (rovery1 + 1) % sizey
        }
        if (roverz == "w") {
            roverx1 = if (roverx1 > 0) roverx1 - 1 else sizex - 1
        }
        if (roverz == "s") {
            rovery1 = if (rovery1 > 0) rovery1 - 1 else sizey - 1
        }
        if (roverz == "e") {
            roverx1 = (roverx1 + 1) % sizex
        }
        return Coordinates(roverx1, rovery1)
    }
}
