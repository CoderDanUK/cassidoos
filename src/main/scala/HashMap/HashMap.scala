package uk.coderdan
package HashMap

case class HashMap() {
  var head: Option[Node] = None
  var tail: Option[Node] = None

  private def isEmpty(): Boolean = {
    head.isEmpty
  }

  private def getNode(key: Int): Option[Node] = {
    if (isEmpty)
      return None

    def getRec(key: Int, node: Node): Option[Node] = {
      if (key == node.key) {
        return Some(node)
      }

      node.next match {
        case Some(nextNode) =>
          getRec(key, nextNode)
        case None =>
          None
      }
    }

    getRec(key, head.get)
  }

  def put(key: Int, value: Int): Unit = {
    def replaceIfExists(key: Int, value: Int): Boolean = {
      val existingNode = getNode(key)
      existingNode match {
        case Some(existing: Node) =>
          existing.value = value
          true
        case None => false
      }
    }

    val node = Node(key, value, None, None)

    if (isEmpty) {
      head = Some(node)
      tail = Some(node)
      return
    }

    if (replaceIfExists(key, value))
      return

    tail match {
      case Some(tailVal: Node) =>
        tailVal.next = Some(node)
        node.prev = tail
        tail = Some(node)
      case None => throw new Exception("Illegal State. Tail does not contain a value.")
    }
  }

  def get(key: Int): Int = {
    val node = getNode(key)

    node match {
      case Some(foundNode) => foundNode.value
      case None => -1
    }
  }

  def remove(key: Int): Unit = {
    val node = getNode(key)
    node match {
      case Some(foundNode) => {
        if (head.isDefined && head.get == foundNode) {
          if (foundNode.next.isDefined)
            head = foundNode.next
          else
            head = None
        }
        if (tail.isDefined && tail.get == foundNode) {
          if (foundNode.prev.isDefined)
            tail = foundNode.prev
          else
            tail = None
        }
        if (foundNode.next.isDefined)
          foundNode.next.get.prev = foundNode.prev
        if (foundNode.prev.isDefined)
          foundNode.prev.get.next = foundNode.next
      }
    }
  }
}
