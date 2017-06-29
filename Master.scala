class Master(val player1: Player, val player2: Player, val board: Board){

  var whites = 12
  var blacks = 12

  player1.giveColor(CheckerColor.White)
  player2.giveColor(CheckerColor.Black)


  def run(): Unit ={

    var isPlayer1Move = true

    while(whites != 0 && blacks != 0){

      val currPlayer = if(isPlayer1Move)
        player1
      else
        player2

      val next = currPlayer.getNextMove(this)
      val possible = getAllPossibleMovesFor(next.start, currPlayer)
      if(possible.contains(next)) {
        makeMove(next, currPlayer)
        if(next.isAttackingMove){
          val attacked = next.whatWasAttacked
          board.free(attacked)

          if(isPlayer1Move)
            blacks -= 1
          else
            whites -= 1
        }
      }

      if(next.isAttackingMove)
        isPlayer1Move = !isPlayer1Move

    }

  }

  def getAllPossibleMovesFor(startPos: Position, player: Player): List[Move] = {
    if(board.whatCheckerAt(startPos) != player.getColor())
      List[Move]()

    var res: List[Move] = List()

    val additives = for(x <- List(-1, 1); y <- List(-1, 1)) yield (x, y)

    for((d, e) <- additives){
      var pos = new Position(startPos.x + d, startPos.y + e)
      if(board.isInsideBoard(pos) && board.whatCheckerAt(pos) == CheckerColor.None)
        res ++= new Move(startPos, pos) :: Nil
      else if(board.isInsideBoard(pos) && board.whatCheckerAt(pos) == player2.getColor){
        val vect = new Position(pos.x - startPos.x, pos.y - startPos.y)

        if(board.isInsideBoard(pos + vect) &&  board.whatCheckerAt(pos) == CheckerColor.None)
          res ++= new Move(startPos, pos) :: Nil
      }
    }

    res

  }


  private[this] def makeMove(move: Move, pl: Player): Unit ={
    board.free(move.start)
    board.standChecker(pl.getColor, move.start)
  }



}
