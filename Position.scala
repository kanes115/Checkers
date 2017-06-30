class Position(val x: Int, val y: Int) {

  def +(pos: Position) = {
    new Position(this.x + pos.x, this.y + pos.y)
  }

  def -(pos: Position) = {
    new Position(this.x - pos.x, this.y - pos.y)
  }

  def *(con: Int) = {
    new Position(this.x * con, this.y * con)
  }

  override def toString: String = "(" + x + ", " + y + ")"
}
