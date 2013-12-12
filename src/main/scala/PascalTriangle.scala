package com.tyler.coursera

object PascalTriangle {
  def pos(col: Int, row: Int): Int = {
    // invariat - column cannot exceed row
    if(col < 1 || col == row)
      1
    else {
      pos(col, row - 1) + pos(col - 1, row - 1)
    }
  }

  def row(r : Int) : Seq[Int] = {
    (0 to r).map( pos(_,r) )
  }

  def triangle : Seq[Seq[Int]] = {
    (Stream from 0).map(row(_))
  }

  // def toString(rows : Int) : String {
  //   val padding = rows / 2
  //   val triangle = 
  //     for(row <- 0 to rows
  //       col <- 0 to r)
  //     yield PascalTriangle.pos(col, row)
  // }
}
