package com.adrrriannn.marsrover

import io.mockk.MockKAdditionalAnswerScope
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.PrintStream
import java.util.Scanner

class MarsRoverShould {

    private val scanner: Scanner = mockk()
    private val printer: PrintStream = mockk()
    private val marsRover = MarsRover(scanner, printer)

    @ParameterizedTest
    @CsvSource(value =
       [
           "5,5,1,1,n,f,1,2,n",
           "5,5,1,1,e,f,2,1,e",
           "5,5,1,1,w,f,0,1,w",
           "5,5,1,1,s,f,1,0,s"
       ])
    fun `move`(horizontalSize: Int,
               verticalSize: Int,
               initialHorizontalPosition: Int, initialVerticalPosition: Int,
               initialDirection: String,
               command: String,
               expectedHorizontalPosition: Int,
               expectedVerticalPosition: Int,
               expectedDirection: String) {

        willPrint("Insert horizontal map size:")
        willPrint("Insert vertical map size:")
        willPrint("Insert horizontal initial rover position:")
        willPrint("Insert vertical initial rover position:")
        willPrint("Insert initial rover direction:")
        willPrint("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
        willPrint("Rover is at x:$expectedHorizontalPosition y:$expectedVerticalPosition facing:$expectedDirection")

        willReturnHorizontalMapSize(horizontalSize)
            .willReturnVerticalMapSize(verticalSize)
            .willReturnRoverInitialHorizontalPosition(initialHorizontalPosition)
            .willReturnRoverInitialVerticalPosition(initialVerticalPosition)

        willReturnRoverInitialDirection(initialDirection)
            .willReturnCommand(command)

        marsRover()

        assertRoverExpectedPositionWasPrinted("Rover is at x:$expectedHorizontalPosition y:$expectedVerticalPosition facing:$expectedDirection")
    }

    @Test
    fun `rotate right`() {
        val horizontalSize = 5
        val verticalSize = 5

        val initialHorizontalPosition = 1
        val initialVerticalPosition = 1
        val initialDirection = "n"
        val command = "r"

        willPrint("Insert horizontal map size:")
        willPrint("Insert vertical map size:")
        willPrint("Insert horizontal initial rover position:")
        willPrint("Insert vertical initial rover position:")
        willPrint("Insert initial rover direction:")
        willPrint("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
        willPrint("Rover is at x:1 y:1 facing:e")

        willReturnHorizontalMapSize(horizontalSize)
            .willReturnVerticalMapSize(verticalSize)
            .willReturnRoverInitialHorizontalPosition(initialHorizontalPosition)
            .willReturnRoverInitialVerticalPosition(initialVerticalPosition)

        willReturnRoverInitialDirection(initialDirection)
            .willReturnCommand(command)

        marsRover()

        assertRoverExpectedPositionWasPrinted("Rover is at x:1 y:1 facing:e")
    }

    @Test
    fun `rotate left`() {
        val horizontalSize = 5
        val verticalSize = 5

        val initialHorizontalPosition = 1
        val initialVerticalPosition = 1
        val initialDirection = "n"
        val command = "l"

        willPrint("Insert horizontal map size:")
        willPrint("Insert vertical map size:")
        willPrint("Insert horizontal initial rover position:")
        willPrint("Insert vertical initial rover position:")
        willPrint("Insert initial rover direction:")
        willPrint("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
        willPrint("Rover is at x:1 y:1 facing:w")

        willReturnHorizontalMapSize(horizontalSize)
            .willReturnVerticalMapSize(verticalSize)
            .willReturnRoverInitialHorizontalPosition(initialHorizontalPosition)
            .willReturnRoverInitialVerticalPosition(initialVerticalPosition)

        willReturnRoverInitialDirection(initialDirection)
            .willReturnCommand(command)

        marsRover()

        assertRoverExpectedPositionWasPrinted("Rover is at x:1 y:1 facing:w")
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


