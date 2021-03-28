package com.adrrriannn.marsrover.context.rotate

class RotateLeftCommand {

    fun rotate(roverInitialPosition: String?): String? {
        var roverInitialPosition1 = roverInitialPosition
        when (roverInitialPosition1) {
            "n" -> {
                roverInitialPosition1 = "w"
            }
            "w" -> {
                roverInitialPosition1 = "s"
            }
            "s" -> {
                roverInitialPosition1 = "e"
            }
            "e" -> {
                roverInitialPosition1 = "n"
            }
        }
        return roverInitialPosition1
    }
}
