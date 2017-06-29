class Position(val x: Int, val y: Int) {

  def +(pos: Position) = {
    new Position(this.x + pos.x, this.y + y)
  }

  def -(pos: Position) = {
    new Position(this.x - pos.x, this.y - y)
  }
}
