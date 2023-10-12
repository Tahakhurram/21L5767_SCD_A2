package scd_a2;

import java.util.ArrayList;
import java.util.List;

public class IntervalMerger {

    public static List<int[]> mergeIntervals(List<int[]> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            if (currentInterval[1] >= interval[0]) {

                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                
                mergedIntervals.add(currentInterval);
                currentInterval = interval;
            }
        }

        mergedIntervals.add(currentInterval);
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{1, 3});
        intervals.add(new int[]{2, 6});
        intervals.add(new int[]{8, 10});
        intervals.add(new int[]{15, 18});

        List<int[]> mergedIntervals = mergeIntervals(intervals);
        System.out.println("Merged Intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
