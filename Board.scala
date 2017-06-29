class Board(){

  startingSet()

  var fields = Array.ofDim[Field](8, 8)

  def isOccupied(x: Int, y: Int) = fields[x][y].isOccupied

  def whatCheckerAt(x: Int, y: Int) = fields[x][y].occupiedBy

  def startingSet(): Unit = {
    var modd: Int = 1
    for(j <- (0 to 2)) {
      for (i <- (0 to 7), i % 2 == modd) field(j)(i).stand(CheckerColor.White)
      modd += 1
      modd %= 2
    }

    for(j <- (5 to 7)) {
      for (i <- (0 to 7), i % 2 == modd) field(j)(i).stand(CheckerColor.White)
      modd += 1
      modd %= 2
    }
  }

}