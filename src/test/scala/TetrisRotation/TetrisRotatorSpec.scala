package uk.coderdan
package TetrisRotation

import org.scalatest.flatspec._
import org.scalatest.matchers._

import scala.language.implicitConversions

class TetrisRotatorSpec extends AnyFlatSpec with should.Matchers {

  "A Tetris Rotator" should "rotate correctly if it is a known pattern" in {
    val rotator = new TetrisRotator()
    Tetrominos.all.foreach(t => {
      rotator.rotateTetromino(t.frames(0), RotationDirection.Clockwise).get should be(t.frames(1))
    })
  }

  it should "wrap around to the last frame if we go anti-clockwise from 0" in {
    val rotator = new TetrisRotator()
    Tetrominos.all.foreach(t => {
      rotator.rotateTetromino(t.frames(0), RotationDirection.AntiClockwise).get should be(t.frames(3))
    })
  }

  it should "wrap around to the first frame if we go clockwise from 3" in {
    val rotator = new TetrisRotator()
    Tetrominos.all.foreach(t => {
      rotator.rotateTetromino(t.frames(3), RotationDirection.Clockwise).get should be(t.frames(0))
    })
  }

  it should "return an error if we don't know what the shape is" in {
    val rotator = new TetrisRotator()
    val unknownFrame = Array(Array(true, true, true), Array(true, true, true))
    val result = rotator.rotateTetromino(unknownFrame, RotationDirection.Clockwise)

    result.isFailure should be(true)
    result.failed.get.getMessage should be("supplied tetromino is not recognised")
  }

  it should "correctly rotate cassidoo's test scenario" in {
    implicit def intToBool(i: Int): Boolean =
      i == 1

    val grid: Array[Array[Boolean]] = Array(
      Array(0, 1, 0, 0),
      Array(0, 1, 1, 1),
      Array(0, 0, 0, 0),
      Array(0, 0, 0, 0)
    )
    val expectedRotation: Array[Array[Boolean]] = Array(
      Array(0, 0, 1, 1),
      Array(0, 0, 1, 0),
      Array(0, 0, 1, 0),
      Array(0, 0, 0, 0)
    )

    val rotator = new TetrisRotator()
    val rotatedGrid = rotator.rotateTetromino(grid, RotationDirection.Clockwise)

    rotatedGrid.get should be(expectedRotation)
  }
}
