package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

public class IntervalProblems {

    /**
     * Merge Intervals 
     * Given a collection of intervals, merge all overlapping intervals.
    For example,
            Given [1,3],[2,6],[8,10],[15,18],
                return [1,6],[8,10],[15,18].
     */

    /**
     *
     * case 1 The intervals do not overlap. We do not have to do any merging.
     * case 2 The intervals partially overlap. We merge interval A and interval B into interval C.
     * case 3 Interval A completely overlaps interval B. Interval B will be merged into interval A
     *
     * case 3
     * ntervals = [[1,3],[5,10],[7,15],[18,30],[22,25]]
     *                0      1      2      3        4
     * # CASE 1
     * interval[0] = [1, 3]
     * interval[1] = [5, 10]
     * front = max(1, 5) = 5
     * back = min(3, 10) = 3
     *   1-- 10
     interval[1] = [5, 10]
     interval[2] = [7, 15]
     front = max(5, 7) = 7
     back = min(10, 15) = 10

     Case 2
     intervals = [[1,3],[5,10],[7,15],[18,30],[22,25]]

     Partial Overlap
     [5     10]
     [7       15]
     becomes...
     [5            15]
     Complete Overlap
     [18                30]
     [22   25]
     becomes...
     [18                30]

     The newly merged interval will be the minimum of the front and the maximum of the end.
     We set the last interval of the result array to this newly merged interval

     */

    /**
     Iterate over intervals
     Check if intervals overlap
     Merge Overlapping intervals

           */
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals);
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++) {
            if(end >= intervals[i][0]) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
                ans.add(new int[] { start, end });
                //ans.set(ans.size()-1,temp);
            }else {
                ans.add(intervals[i]);

            }


        }
        return ans.toArray(new int[ans.size()][]);

    }

    public int[][] merge2(int[][] intervals) {

        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++) {
            if (intervals[i][0] > end) {
                ans.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }

        }
        ans.add(new int[] {start, end});
        return ans.toArray(new int[ans.size()][]);

    }


}