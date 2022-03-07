package uk.coderdan
package HashMap
import org.scalatest.flatspec._
import org.scalatest.matchers._

class HashMapTest extends AnyFlatSpec with should.Matchers {
  "A Hashmap" should "retrieve a value if it has been added" in {
    val hashMap = new HashMap
    hashMap.put(1, 10)
    hashMap.get(1) should be (10)
  }

  it should "update a value if a key has already been used" in {
    val hashMap = new HashMap
    hashMap.put(1, 42)
    hashMap.put(1, 43)
    hashMap.get(1) should be (43)
  }

  it should "not return a value if it has been removed" in {
    val hashMap = new HashMap
    hashMap.put(1, 42)
    hashMap.get(1) should be (42)
    hashMap.remove(1)
    hashMap.get(1) should be (-1)
  }
}
