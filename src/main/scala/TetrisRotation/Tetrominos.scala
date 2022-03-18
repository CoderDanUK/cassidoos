package uk.coderdan
package TetrisRotation

import scala.language.implicitConversions

case object Tetrominos {
  implicit def intToBool(i: Int): Boolean =
    i == 1

  val I: Tetromino = Tetromino(Array(
    Array(
      Array(0, 0, 0, 0),
      Array(1, 1, 1, 1),
      Array(0, 0, 0, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 1, 0),
      Array(0, 0, 1, 0),
      Array(0, 0, 1, 0),
      Array(0, 0, 1, 0)
    ),
    Array(
      Array(0, 0, 0, 0),
      Array(0, 0, 0, 0),
      Array(1, 1, 1, 1),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 1, 0, 0),
      Array(0, 1, 0, 0),
      Array(0, 1, 0, 0),
      Array(0, 1, 0, 0)
    ),
  ), TetrominoIdentifier.I)

  val J: Tetromino = Tetromino(Array(
    Array(
      Array(0, 1, 0, 0),
      Array(0, 1, 1, 1),
      Array(0, 0, 0, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 1, 1),
      Array(0, 0, 1, 0),
      Array(0, 0, 1, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 0, 0),
      Array(0, 1, 1, 1),
      Array(0, 0, 0, 1),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 1, 0),
      Array(0, 0, 1, 0),
      Array(0, 1, 1, 0),
      Array(0, 0, 0, 0)
    ),
  ), TetrominoIdentifier.J)

  val L: Tetromino = Tetromino(Array(
    Array(
      Array(0, 0, 0, 1),
      Array(0, 1, 1, 1),
      Array(0, 0, 0, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 1, 0),
      Array(0, 0, 1, 0),
      Array(0, 0, 1, 1),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 0, 0),
      Array(0, 1, 1, 1),
      Array(0, 1, 0, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 1, 1, 0),
      Array(0, 0, 1, 0),
      Array(0, 0, 1, 0),
      Array(0, 0, 0, 0)
    ),
  ), TetrominoIdentifier.L)

  val O: Tetromino = Tetromino(Array(
    Array(
      Array(0, 1, 1, 0),
      Array(0, 1, 1, 0),
      Array(0, 0, 0, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 1, 1, 0),
      Array(0, 1, 1, 0),
      Array(0, 0, 0, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 1, 1, 0),
      Array(0, 1, 1, 0),
      Array(0, 0, 0, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 1, 1, 0),
      Array(0, 1, 1, 0),
      Array(0, 0, 0, 0),
      Array(0, 0, 0, 0)
    ),
  ), TetrominoIdentifier.O)

  val S: Tetromino = Tetromino(Array(
    Array(
      Array(0, 0, 1, 1),
      Array(0, 1, 1, 0),
      Array(0, 0, 0, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 1, 0),
      Array(0, 0, 1, 1),
      Array(0, 0, 0, 1),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 0, 0),
      Array(0, 0, 1, 1),
      Array(0, 1, 1, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 1, 0, 0),
      Array(0, 1, 1, 0),
      Array(0, 0, 1, 0),
      Array(0, 0, 0, 0)
    ),
  ), TetrominoIdentifier.S)

  val T: Tetromino = Tetromino(Array(
    Array(
      Array(0, 0, 1, 0),
      Array(0, 1, 1, 1),
      Array(0, 0, 0, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 1, 0),
      Array(0, 0, 1, 1),
      Array(0, 0, 1, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 0, 0),
      Array(0, 1, 1, 1),
      Array(0, 0, 1, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 1, 0),
      Array(0, 1, 1, 0),
      Array(0, 0, 1, 0),
      Array(0, 0, 0, 0)
    ),
  ), TetrominoIdentifier.T)

  val Z: Tetromino = Tetromino(Array(
    Array(
      Array(0, 1, 1, 0),
      Array(0, 0, 1, 1),
      Array(0, 0, 0, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 0, 1),
      Array(0, 0, 1, 1),
      Array(0, 0, 1, 0),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 0, 0),
      Array(0, 1, 1, 0),
      Array(0, 0, 1, 1),
      Array(0, 0, 0, 0)
    ),
    Array(
      Array(0, 0, 1, 0),
      Array(0, 1, 1, 0),
      Array(0, 1, 0, 0),
      Array(0, 0, 0, 0)
    ),
  ), TetrominoIdentifier.Z)

  val all: Array[Tetromino] = Array(I, J, L, O, S, T, Z)
}
