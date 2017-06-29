import CheckerColor._

abstract class Player(var myColor: CheckerColor, var myName: String){

  if(myColor == CheckerColor.None)
    throw new IllegalArgumentException("You must specify a certain color, not a None")

  var color: CheckerColor = myColor


  def getNextMove(master: Master): Move

  def getName(): String = myName

  def giveColor(color: CheckerColor) = {
    if(color == CheckerColor.None)
      throw new IllegalArgumentException("You must specify a certain color, not a None")

    myColor = color
  }

  def getColor(): CheckerColor = {
    myColor
  }

}
