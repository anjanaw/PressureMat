/*
 * CostMatrix.java   Jul 14, 2004
 *
 * Copyright (c) 2004 Stan Salvador
 * stansalvador@hotmail.com
 */

package com.dtw;


interface CostMatrix
{
   void put(int col, int row, double value);

   double get(int col, int row);

   int size();

}  // end interface CostMatrix
