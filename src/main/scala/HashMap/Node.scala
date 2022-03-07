package uk.coderdan
package HashMap

case class Node(key: Int, var value: Int, var next: Option[Node], var prev: Option[Node])
