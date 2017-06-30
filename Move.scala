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
}
