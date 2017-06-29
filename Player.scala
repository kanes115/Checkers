abstract class Player(color: CheckerColor){

  if(color == CheckerColor.None)
    throw new IllegalArgumentException("You must specify a certain color, not a None")

  var color: CheckerColor = color


  def getNextMove(master: Master): Move

  def getName(): String

  def giveColor(color: CheckerColor) = {
    if(color == CheckerColor.None)
      throw IllegalArgumentException("You must specify a certain color, not a None")

    this.color = color
  }

  def getColor(): CheckerColor = {
    color
  }

}
