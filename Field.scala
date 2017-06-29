class Field(val x, val y, var occupiedBy: CheckerColor = CheckerColor.None){

  if(x < 0 || x > 7)
    throw new IllegalArgumentException("Field must be between 0 and 7");

  def free(): Unit ={
    occupiedBy = CheckerColor.None
  }

  def standChecker(checker: CheckerColor): Unit ={
    occupiedBy = checker
  }

  def isOccupied(): Unit ={
    case occupiedBy match{
      CheckerColor.None => false
      _ => true
    }
  }

}

