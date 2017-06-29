import CheckerColor._

class Board(){

  val boardSize = 8


  var fields = Array.ofDim[Field](boardSize, boardSize)

  for(i <- (0 to 7))
    for(j <- (0 to 7))
      fields(i)(j) = new Field(i, j, CheckerColor.None)

  startingSet()

  def isOccupied(pos: Position) = fields(pos.x)(pos.y).isOccupied

  def whatCheckerAt(pos: Position) = {
    println(pos.x, pos.y)
    fields(pos.x)(pos.y).occupiedBy
  }

  def startingSet(): Unit = {
    var modd: Int = 1
    for(j <- (0 to 2)) {
      for (i <- (0 to 7) if i % 2 == modd){
        fields(j)(i) = new Field(j, i, CheckerColor.White)
      }
      modd += 1
      modd %= 2
    }

    for(j <- (5 to 7)) {
      for (i <- (0 to 7) if i % 2 == modd) {
        fields(j)(i) = new Field(j, i, CheckerColor.Black)
      }
      modd += 1
      modd %= 2
    }
  }

  override def toString: String = {
    var res: String = " 1 2 3 4 5 6 7 8"
    for(i <- (0 until boardSize)){
      res += "\n|"
      for(j <- (0 until boardSize)){
        res += fields(i)(j).occupiedBy.toString + "|"
      }
      res += " " + (i + 1 + 64).toChar
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
    fields(pos.x)(pos.y).standChecker(CheckerColor.None)
  }




}
