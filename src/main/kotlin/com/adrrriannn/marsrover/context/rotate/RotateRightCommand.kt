package com.adrrriannn.marsrover.context.rotate

class RotateRightCommand {
    fun rotate(roverInitialPosition: String?): String? {
        var roverInitialPosition1 = roverInitialPosition
        when (roverInitialPosition1) {
            "n" -> {
                roverInitialPosition1 = "e"
            }
            "e" -> {
                roverInitialPosition1 = "s"
            }
            "s" -> {
                roverInitialPosition1 = "w"
            }
            "w" -> {
                roverInitialPosition1 = "n"
            }
        }
        return roverInitialPosition1
    }
}
