class Master(val player1: Player, val player2: Player, val board: Board){

  var whites = 12
  var blacks = 12

  player1.giveColor(CheckerColor.White)
  player1.giveColor(CheckerColor.Blacks)


  def run(): Unit ={

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
        val vect = (pos.x - startPos.x, pos.y - startPos.y)

      }
    }




  }



}