package uk.coderdan
package HashMap

import org.scalatest.flatspec._
import org.scalatest.matchers._

class HashMapTest extends AnyFlatSpec with should.Matchers {
  "A Hashmap" should "retrieve a value if it has been added" in {
    val hashMap = new HashMap
    hashMap.put(1, 10)
    hashMap.get(1) should be(10)
  }

  it should "update a value if a key has already been used" in {
    val hashMap = new HashMap
    hashMap.put(1, 42)
    hashMap.put(1, 43)
    hashMap.get(1) should be(43)
  }

  it should "not return a value if it has been removed" in {
    val hashMap = new HashMap
    hashMap.put(1, 42)
    hashMap.get(1) should be(42)
    hashMap.remove(1)
    hashMap.get(1) should be(-1)
  }

  it should "not return a value if the list is empty" in {
    val hashMap = new HashMap
    hashMap.get(1) should be(-1)
  }

  it should "return the correct value when there are multiple" in {
    val hashMap = new HashMap
    hashMap.put(1, 1)
    hashMap.put(2, 2)
    hashMap.put(3, 42)
    hashMap.put(4, 4)
    hashMap.put(5, 5)
    hashMap.get(3) should be(42)
    hashMap.get(6) should be(-1)

    hashMap.remove(3)
    hashMap.get(1) should be(1)
    hashMap.get(2) should be(2)
    hashMap.get(3) should be(-1)
    hashMap.get(4) should be(4)
    hashMap.get(5) should be(5)
  }
}
