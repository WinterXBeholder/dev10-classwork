import java.util.Arrays;
import java.util.Random;

public class Exercise16 {

    public static void main(String[] args) {
        // MERGE
        int[] one = makeRandomAscendingArray();
        int[] two = makeRandomAscendingArray();

        // makeRandomAscendingArray creates a random array with a capacity between 50 and 150.
        // Its elements are guaranteed to be sorted ascending.
        // 1. Create a new int[] with capacity for all elements from `one` and `two`.
        // 2. "Merge" elements from `one` and `two` into the new array so that its values are sorted.

         /* Pseudocode:
         Create an integer index for `one`, `two`, and the result array, all starting at 0.
         Loop resultIndex from 0 to result.length - 1:
           if one[oneIndex] is less than two[twoIndex], add it to the result and increment oneIndex.
           if two[twoIndex] is less than one[oneIndex], add it to the result and increment twoIndex.
           determine how to settle ties
           if oneIndex >= one.length, there are no `one` elements remaining so use elements from two
           if twoIndex >= two.length, there are no `two` elements remaining so use elements from one
          */

        int[] target = new int[one.length + two.length];
        int[][] lrg1st = new int[2][];
        lrg1st[0] = one.length >= two.length ? one : two;
        lrg1st[1] = one.length < two.length ? one : two;

        for (int lrgIndex = 0, smlIndex = 0, targetIndex = 0; smlIndex <= lrg1st[1].length; targetIndex++) {
            if (smlIndex == lrg1st[1].length) {
                finish(target, targetIndex, lrg1st[0], lrgIndex);
                break;
            } else if (lrgIndex == lrg1st[0].length) {
                finish(target, targetIndex, lrg1st[1], smlIndex);
                break;
            } else if (lrg1st[0][lrgIndex] <= lrg1st[1][smlIndex]){
                target[targetIndex] = lrg1st[0][lrgIndex];
                lrgIndex++;
            } else {
                target[targetIndex] = lrg1st[1][smlIndex];
                smlIndex++;
            }
        }
        System.out.printf("array one: %s%n", Arrays.toString(one));
        System.out.printf("array two: %s%n", Arrays.toString(two));
        System.out.printf("array target: %s%n", Arrays.toString(target));
    }

    public static int[] makeRandomAscendingArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        int current = random.nextInt(11);
        for (int i = 0; i < result.length; i++) {
            result[i] = current;
            current += random.nextInt(4);
        }
        return result;
    }

    public static void finish(int[] target, int startTarget, int[] source, int startSource) {
        for (; startSource < source.length; startSource++, startTarget++) {
            target[startTarget] = source[startSource];
        }
    }
}
