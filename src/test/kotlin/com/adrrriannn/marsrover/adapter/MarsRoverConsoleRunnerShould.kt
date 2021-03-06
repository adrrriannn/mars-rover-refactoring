package com.adrrriannn.marsrover.adapter

import com.adrrriannn.marsrover.adapter.MarsRoverConsoleRunner
import io.mockk.MockKAdditionalAnswerScope
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.PrintStream
import java.util.Scanner

class MarsRoverConsoleRunnerShould {

    private val scanner: Scanner = mockk()
    private val printer: PrintStream = mockk()
    private val marsRover = MarsRoverConsoleRunner(scanner, printer)

    @ParameterizedTest
    @CsvSource(value =
       [
           "5,5,1,1,n,f,1,2,n",
           "5,5,1,1,e,f,2,1,e",
           "5,5,1,1,w,f,0,1,w",
           "5,5,1,1,s,f,1,0,s",

           "5,5,1,1,n,b,1,0,n",
           "5,5,1,1,e,b,0,1,e",
           "5,5,1,1,w,b,2,1,w",
           "5,5,1,1,s,b,1,2,s"
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

    @ParameterizedTest
    @CsvSource(value =
               [
                   "5,5,4,4,n,f,4,0,n",
                   "5,5,4,4,e,f,0,4,e",
                   "5,5,0,0,w,f,4,0,w",
                   "5,5,0,0,s,f,0,4,s",

                   "5,5,0,0,n,b,0,4,n",
                   "5,5,0,0,e,b,4,0,e",
                   "5,5,4,4,w,b,0,4,w",
                   "5,5,4,4,s,b,4,0,s"
               ])
    fun `move over the horizon`(horizontalSize: Int,
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

    @ParameterizedTest
    @CsvSource(value =
               [
                   "5,5,1,1,n,r,1,1,e",
                   "5,5,1,1,e,r,1,1,s",
                   "5,5,1,1,s,r,1,1,w",
                   "5,5,1,1,w,r,1,1,n",

                   "5,5,1,1,n,l,1,1,w",
                   "5,5,1,1,e,l,1,1,n",
                   "5,5,1,1,s,l,1,1,e",
                   "5,5,1,1,w,l,1,1,s"
               ])
    fun `rotate`(horizontalSize: Int,
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


