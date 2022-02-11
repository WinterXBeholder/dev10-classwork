import java.util.Arrays;
import java.util.Random;

public class Exercise15 {

    public static void main(String[] args) {
        int[] one = makeRandomArray();
        int[] two = makeRandomArray();

        // 1. Create a new int[] with room enough for all elements in `one` and `two`.
        // 2. Copy elements from `one` into the beginning of the array.
        // 3. Copy elements from `two` at the end of the array.
        // 4. Print the results to confirm that it worked.

        int[] target = new int[one.length + two.length];

        finish(target, 0, one, 0);
        finish(target, one.length, two, 0);

        System.out.printf("array one: %s%n", Arrays.toString(one));
        System.out.printf("array two: %s%n", Arrays.toString(two));
        System.out.printf("array target: %s%n", Arrays.toString(target));
    }

    public static int[] makeRandomArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(1000) - 500;
        }
        return result;
    }

    public static void finish(int[] target, int startTarget, int[] source, int startSource) {
        for (; startSource < source.length; startSource++, startTarget++) {
            target[startTarget] = source[startSource];
        }
    }
}
