package com.adrrriannn.marsrover

import io.mockk.MockKAdditionalAnswerScope
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.io.PrintStream
import java.util.Scanner

class MarsRoverShould {

    private val scanner: Scanner = mockk()
    private val printer: PrintStream = mockk()
    private val marsRover = MarsRover(scanner, printer)

    @Test
    fun `move forward`() {
        val horizontalSize = 5
        val verticalSize = 5

        val initialHorizontalPosition = 0
        val initialVerticalPosition = 0
        val initialDirection = "n"
        val command = "f"

        willPrint("Insert horizontal map size:")
        willPrint("Insert vertical map size:")
        willPrint("Insert horizontal initial rover position:")
        willPrint("Insert vertical initial rover position:")
        willPrint("Insert initial rover direction:")
        willPrint("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
        willPrint("Rover is at x:0 y:1 facing:n")

        willReturnHorizontalMapSize(horizontalSize)
        .willReturnVerticalMapSize(verticalSize)
        .willReturnRoverInitialHorizontalPosition(initialHorizontalPosition)
        .willReturnRoverInitialVerticalPosition(initialVerticalPosition)

        willReturnRoverInitialDirection(initialDirection)
        .willReturnCommand(command)

        marsRover()

        assertRoverExpectedPositionWasPrinted("Rover is at x:0 y:1 facing:n")
    }

    private fun willPrint(message: String) {
        every { printer.println(message) } just Runs
    }

    private fun willReturnHorizontalMapSize(horizontalSize: Int) =
        every { scanner.nextInt() } returns horizontalSize

    private fun MockKAdditionalAnswerScope<Int, Int>.willReturnRoverInitialVerticalPosition(initialVerticalPosition: Int) =
        andThen { initialVerticalPosition }

    private fun MockKAdditionalAnswerScope<Int, Int>.willReturnRoverInitialHorizontalPosition(initialHorizontalPosition: Int) =
        andThen { initialHorizontalPosition }

    private fun MockKAdditionalAnswerScope<Int, Int>.willReturnVerticalMapSize(verticalSize: Int) =
        andThen { verticalSize}

    private fun MockKAdditionalAnswerScope<String, String>.willReturnCommand(command: String) =
        andThen { command }

    private fun willReturnRoverInitialDirection(initialDirection: String) =
        every { scanner.next() } returns initialDirection

    private fun assertRoverExpectedPositionWasPrinted(message: String) {
         verify { printer.println(message) }
    }
}


