class Board(){

  val boardSize = 8

  startingSet()

  var fields = Array.ofDim[Field](boardSize, boardSize)

  def isOccupied(pos: Position) = fields(pos.x)(pos.y).isOccupied

  def whatCheckerAt(pos: Position) = fields(pos.x)(pos.y).occupiedBy

  def startingSet(): Unit = {
    var modd: Int = 1
    for(j <- (0 to 2)) {
      for (i <- (0 to 7) if i % 2 == modd) fields(j)(i).standChecker(CheckerColor.White)
      modd += 1
      modd %= 2
    }

    for(j <- (5 to 7)) {
      for (i <- (0 to 7) if i % 2 == modd) fields(j)(i).standChecker(CheckerColor.White)
      modd += 1
      modd %= 2
    }
  }

  override def toString: String = {
    var res: String = "-" * (boardSize + 2)
    for(i <- (0 to boardSize)){
      res += "\n|"
      for(j <- (0 to boardSize)){
        res += fields(i)(j).occupiedBy + "|"
      }
    }
    res
  }

  def isInsideBoard(pos: Position): Boolean = {
    if(pos.x >= 0 && pos.x < boardSize && pos.y >= 0 && pos.y < boardSize)
      true
    false
  }

  def standChecker(checker: CheckerColor, pos: Position): Unit ={
    fields(pos.x)(pos.y).standChecker(checker)
  }

  def free(pos: Position) {
    fields(pos.x)(pos.y) = CheckerColor.None
  }




}
