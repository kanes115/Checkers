class Move(val start: Position, val end: Position) {

  def isAttackingMove(): Boolean = {
    if(Math.abs(start.x - end.x) > 1)
      true
    false
  }

  def whatWasAttacked(): Position = end - start
}
