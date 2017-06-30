class Master(val player1: Player, val player2: Player, val board: Board){

  var whites = 12
  var blacks = 12

  player1.giveColor(CheckerColor.White)
  player2.giveColor(CheckerColor.Black)


  def run(): Unit ={

    var isPlayer1Move = true

    while(whites != 0 && blacks != 0){

      println(board)

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

          //to check if now has attacking moves

          val afterMoves = getAllPossibleMovesFor(next.end, currPlayer)

          if(!afterMoves.filter(e => e.isAttackingMove).isEmpty)
            isPlayer1Move = !isPlayer1Move
        }
        isPlayer1Move = !isPlayer1Move
      }
      else
        println("incorrect move!")
    }

  }

  //tu błąd
  def getAllPossibleMovesFor(startPos: Position, player: Player): Set[Move] = {
    if(board.whatCheckerAt(startPos) != player.getColor()) {
      println("Not your piece")
      Set[Move]()
    }

    var res: Set[Move] = Set()

    val additives = for(x <- List(-1, 1); y <- List(-1, 1)) yield (x, y)

    for((d, e) <- additives){

      val vector = new Position(d, e)

      var destPos = startPos + vector

      if(board.isInsideBoard(destPos) && board.whatCheckerAt(destPos) == CheckerColor.None)
        res ++= new Move(startPos, destPos) :: Nil
      else if(board.isInsideBoard(destPos) && (board.whatCheckerAt(destPos) != player.getColor && board.whatCheckerAt(destPos) != CheckerColor.None)){

        if(board.isInsideBoard(destPos + vector) &&  board.whatCheckerAt(destPos + vector) == CheckerColor.None)
          res ++= new Move(startPos, destPos + vector) :: Nil
      }
    }
    res
  }


  private[this] def makeMove(move: Move, pl: Player): Unit ={
    println(move)
    println(pl)
    board.free(move.start)
    board.standChecker(pl.getColor, new Position(move.end.x, move.end.y))
  }



}
