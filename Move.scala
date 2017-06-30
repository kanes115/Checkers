class Move(val start: Position, val end: Position) {

  def isAttackingMove(): Boolean = {
    if(Math.abs(start.x - end.x) > 1)
      true
    false
  }

  def whatWasAttacked(): Position = end - start

  override def toString: String = {
    val res = "From " + start + "to" + end
    if(isAttackingMove)
      res + "was attacking " + whatWasAttacked.toString
    res
  }

  override def equals(obj: scala.Any): Boolean = {
    obj match{
      case other: Move =>
        if(start.x == other.start.x && end.x == other.end.x && start.y == other.start.y && end.y == other.end.y)
          return true
        else
          return false
      case _ => false
    }
  }
}