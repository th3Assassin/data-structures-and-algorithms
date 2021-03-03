package greedy_algorithms;

import java.util.*;

/**
 * ACTIVITY SELECTION PROBLEM
 *  Input: N activities with their start and finish times
 *  Output: The maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a time.
 *
 * EXAMPLE
 *  Input:
 *      N = 6
 *      start[] = [1, 3, 0, 5, 8, 5]
 *      finish[] = [2, 4, 6, 7, 9, 9]
 *  Output: 4
 *
 * SOLUTION
 *  1/ Sort activities according to finish times
 *  2/ Select the first activity as pivot
 *  3/ For the remaining activities in sorted array
 *      a/ If the start time of that activity is greater than or equal to the finish
 *  time of previously pivot activity, we will increase max number activities and use
 *  that activity as pivot.
 *      b/ Otherwise continue
 */
public class ActivitySelection {

    public static void solve(int numberActivities, int[] startTimes, int[] finishTimes) {

        class Activity {
            final int startTime;
            final int finishTime;

            Activity(int startTime, int finishTime) {
                this.startTime = startTime;
                this.finishTime = finishTime;
            }
        }

        List<Activity> list = new ArrayList<>();
        for (int i = 0;i < numberActivities;++i) {
            list.add(new Activity(startTimes[i], finishTimes[i]));
        }

        Collections.sort(list, new Comparator<Activity>() {
            public int compare(Activity a, Activity b) {
                return a.finishTime - b.finishTime;
            }
        });

        int max = 1;
        int currentFinishTime = list.get(0).finishTime;

        for (int i = 1;i < list.size();++i) {
            if (list.get(i).startTime >= currentFinishTime) {
                currentFinishTime = list.get(i).finishTime;
                ++max;
            }
        }

        System.out.println("Max activities: " + max);
    }

    public static void main(String[] args) {
        int numberActivities;
        int[] startTimes, finishTimes;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number activities: ");
        numberActivities = sc.nextInt();

        startTimes = new int[numberActivities];
        finishTimes = new int[numberActivities];
        System.out.print("Enter list of start times: ");
        for (int i = 0;i < numberActivities;++i) {
            startTimes[i] = sc.nextInt();
        }
        System.out.print("Enter list of finish times: ");
        for (int i = 0;i < numberActivities;++i) {
            finishTimes[i] = sc.nextInt();
        }

        solve(numberActivities, startTimes, finishTimes);
    }
}
