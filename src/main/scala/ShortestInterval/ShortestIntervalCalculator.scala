package uk.coderdan
package ShortestInterval

import scala.annotation.tailrec

object ShortestIntervalCalculator {

  private case class Time(hours: Int, minutes: Int) {
    def totalMinutes: Int = (hours * 60) + minutes

    override def toString(): String = {
      val hoursPart = s"$hours hour${if (hours > 1) "s" else ""}"
      val minutesPart = s"$minutes minute${if (minutes > 1) "s" else ""}"

      if (hours > 0 && minutes > 0) {
        s"$hoursPart $minutesPart"
      } else if (hours > 0) {
        s"$hoursPart"
      } else {
        s"$minutesPart"
      }
    }
  }

  private object Time {
    def fromString(input: String): Time = {
      val parts = input.split(":")
        .map(x => x.toInt)

      Time(parts(0), parts(1))
    }
  }

  private def timeDiff(startTime: Time, endTime: Time): Time = {
    val diffHours = endTime.hours - startTime.hours
    val diffMinutes = endTime.minutes - startTime.minutes
    val totalMinutes = diffHours * 60 + diffMinutes
    Time(totalMinutes / 60, totalMinutes % 60)
  }

  @tailrec
  private def getShortestTimeRec(times: Array[Time], currTime: Int, shortestTime: Option[Time]): Option[Time] = {
    if (currTime == times.length - 1)
      return shortestTime

    val diff = timeDiff(times(currTime), times(currTime + 1))

    val newShortestTime = if (shortestTime.isEmpty || shortestTime.get.totalMinutes > diff.totalMinutes)
        Some(diff)
      else
        shortestTime

    getShortestTimeRec(times, currTime + 1, newShortestTime)
  }

  def apply(input: Array[String]): String = {
    val notFoundResult = "Could not find the shortest time"

    if (input.length == 0) {
      return notFoundResult
    }

    val times = input.map(Time.fromString)
    getShortestTimeRec(times, 0, None) match {
      case Some(result) => result.toString()
      case None => notFoundResult
    }
  }
}
