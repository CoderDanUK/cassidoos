package uk.coderdan
package TetrisRotation

import scala.util.Try

class TetrisRotator {
  def rotateTetromino(data: Array[Array[Boolean]], direction: RotationDirection.Value): Try[Array[Array[Boolean]]] = {
    Tetrominos.all.find(t => t.hasFrame(data)) match {
      case Some(tetromino) => Try(tetromino.rotate(data, direction))
      case None => Try(throw new Exception("supplied tetromino is not recognised"))
    }
  }
}
