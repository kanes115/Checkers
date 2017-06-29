class AIPlayer(val myColor: CheckerColor, val amountOfForwardMoves: Int) extends Player{


  def getNextMove(master: Master): Move = {
    List[Move] allMoves = getAllPossibleMoves(master)

    val mockMaster: Master = new Master(master)   //zalezy jak bedzie wygladal master, prototypowanie?

    makeMovesOnMaster(mockMaster, allMoves, amountOfForwardMoves)

  }


  def makeMovesOnMaster(val master: Master, val moves: List[Move], deepLvl: Int): Int = {
    if(deepLvl == amountOfForwardMoves)
      master.getAmountOfCheckers(myColor)
    var maxx: Int = -1

    for(m <- moves) {
      master.makeMove(m)
      val curr: Int = makeMovesOnMaster(master, getAllPossibleMoves(master), deepLvl + 1)
      if(curr > maxx) maxx = curr
    }
    maxx
  }

  private[this] def getAllPossibleMoves(master: Master) = {

    var myMoves = new List[Move]()

    myMoves = for(x <- (0 to board.boardSize), y <- (0 to board.boardSize), board.whatCheckerAt(x, y) == myColor)
      yield master.getAllPossibleMovesFor(board, x, y)

    myMoves.flatten
  }





}

