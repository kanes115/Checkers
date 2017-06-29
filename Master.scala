class Master(val player1: Player, val player2: Player, val board: Board){

  var whites = 12
  var blacks = 12

  player1.giveColor(CheckerColor.White)
  player2.giveColor(CheckerColor.Blacks)


  def run(): Unit ={

    var isPlayer1Move = true

    while(whites != 0 && blacks != 0){
      var currPlayer: Player

      currPlayer = if(isPlayer1Move)
        player1
      else
        player2

      val next = currPlayer.getNextMove()
      List[Move] possible = getAllPossibleMovesFor(next.start, currPlayer)
      if(possible.contains(next)) {
        makeMove(next)
        if(next.isAttackingMove){
          val attacked = next.whatWasAttacked
          board.free(attacked)
          blacks -= 1
        }
      }

      if(next.isAttackingMove)
        ifcurrPlayer = !currPlayer

    }

  }

  def getAllPossibleMovesFor(startPos: Position, player: Player): List[Move] = {
    if(board.whatCheckerAt(x, y) != player.getColor())
      List[Move]()

    var res = new List[Move]()

    val additives = for(x <- (-1, 1), y <- (-1, 1)) yield (x, y)

    for((d, e) <- additives){
      var pos = new Position(x + d, y + e)
      if(board.isInsideBoard(pos) && board.whatCheckerAt(pos) == CheckerColor.None)
        res += Move(startPos, pos)
      else if(board.isInsideBoard(pos) && board.whatCheckerAt(pos) == player2.getColor){
        val vect = new Position(pos.x - startPos.x, pos.y - startPos.y)

        if(board.isInsideBoard(pos + vect) &&  board.whatCheckerAt(pos) == CheckerColor.None)
          res += Move(startPos, pos)
      }
    }

  }



}