/*
 * FastDtwTest.java   Jul 14, 2004
 *
 * Copyright (c) 2004 Stan Salvador
 * stansalvador@hotmail.com
 */

package com;

import com.timeseries.TimeSeries;
import com.util.DistanceFunction;
import com.util.DistanceFunctionFactory;
import com.dtw.TimeWarpInfo;


/**
 * This class contains a main method that executes the FastDTW algorithm on two
 * time series with a specified radius.
 *
 * @author Stan Salvador, stansalvador@hotmail.com
 * @since Jul 14, 2004
 */
public class FastDtwTest
{
   /**
    * This main method executes the FastDTW algorithm on two time series with a
    * specified radius. The time series arguments are file names for files that
    * contain one measurement per line (time measurements are an optional value
    * in the first column). After calculating the warp path, the warp
    * path distance will be printed to standard output, followed by the path
    * in the format "(0,0),(1,0),(2,1)..." were each pair of numbers in
    * parenthesis are indexes of the first and second time series that are
    * linked in the warp path
    *
    * @param args  command line arguments (see method comments)
    */
      public static void main(String[] args) {
         final TimeSeries tsI = new TimeSeries("C:\\IdeaProjects\\Data\\count\\step\\template.csv", false, false, ',');
         for(int i=0; i<799; i++) {
            final TimeSeries tsJ = new TimeSeries("C:\\IdeaProjects\\Data\\count\\step\\timeseries_"+i+".csv", false, false, ',');

            final DistanceFunction distFn = DistanceFunctionFactory.getDistFnByName("EuclideanDistance");
            final TimeWarpInfo info = com.dtw.FastDTW.getWarpInfoBetween(tsI, tsJ, 1, distFn);

            System.out.println(info.getDistance());
         }
      }

}  // end class FastDtwTest
