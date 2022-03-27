package uk.coderdan
package ShortestInterval

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class ShortestIntervalCalculatorSpec extends AnyFlatSpec with should.Matchers {

  "A Shortest Interval Calculator" should "get 5 minutes within the same hour" in {
    val times = Array("01:15", "03:45", "03:50", "04:00")
    val result = ShortestIntervalCalculator(times)
    result should be ("5 minutes")
  }

  it should "get 10 minutes and no hours" in {
    val times = Array("01:55", "02:05", "02:50")
    val result = ShortestIntervalCalculator(times)
    result should be ("10 minutes")
  }

  it should "get exact hours and no minutes formatted correctly" in {
    val times = Array("12:00", "15:00")
    val result = ShortestIntervalCalculator(times)
    result should be ("3 hours")
  }

  it should "get the result from only two options" in {
    val times = Array("03:00", "05:30")
    val result = ShortestIntervalCalculator(times)
    result should be ("2 hours 30 minutes")
  }

  it should "not be able to find a result with only one item" in {
    val times = Array("03:00")
    val result = ShortestIntervalCalculator(times)
    result should be ("Could not find the shortest time")
  }

  it should "not be able to find a result with no items" in {
    val times: Array[String] = Array()
    val result = ShortestIntervalCalculator(times)
    result should be ("Could not find the shortest time")
  }

}
