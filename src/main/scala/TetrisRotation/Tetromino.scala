package uk.coderdan
package TetrisRotation

case class Tetromino(frames: Array[Array[Array[Boolean]]], identifier: TetrominoIdentifier.Value) {
  def tryGetFrame(frame: Array[Array[Boolean]]): Option[(Array[Array[Boolean]], Int)] = {
    frames.zipWithIndex.find(tetFrame => {
      (tetFrame._1(0) sameElements frame(0)) &&
        (tetFrame._1(1) sameElements frame(1)) &&
        (tetFrame._1(2) sameElements frame(2)) &&
        (tetFrame._1(3) sameElements frame(3))
    })
  }

  def hasFrame(frame: Array[Array[Boolean]]): Boolean = {
    tryGetFrame(frame).isDefined
  }

  def getCurrentFrame(frame: Array[Array[Boolean]]): Int = {
    val foundFrame = tryGetFrame(frame)
    foundFrame match {
      case Some(result) => result._2
      case None => throw new Exception("Unknown frame")
    }
  }

  def rotate(
    frame: Array[Array[Boolean]],
    direction: RotationDirection.Value
  ): Array[Array[Boolean]] = {
    val currentFrame = getCurrentFrame(frame)
    direction match {
      case RotationDirection.Clockwise =>
        currentFrame match {
          case 3 => frames(0)
          case _ => frames(currentFrame + 1)
        }
      case RotationDirection.AntiClockwise =>
        currentFrame match {
          case 0 => frames(3)
          case _ => frames(currentFrame - 1)
        }
      case _ => throw new Exception(s"Rotation direction $direction is not known")
    }
  }
}
