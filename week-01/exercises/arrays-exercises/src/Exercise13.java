import java.util.Arrays;
import java.util.Random;

public class Exercise13 {

    public static void main(String[] args) {
        String[] statesOrTowns = makeRandomStateAndTownArray();

        // The statesOrTowns array contains either state abbreviations or town names. You can distinguish state
        // abbreviations by their length. They're always two characters.
        // 1. Count the towns.
        // 2. Create a String[] to hold the towns.
        // 3. Loop through statesOrTowns a second time and put all towns in the new array.
        // 4. Print the town array.
        int count = 0;
        for (int i = 0; i < statesOrTowns.length; i++) {
            if (statesOrTowns[i].length() != 2) {
                count++;
            }
        }
        String[] towns = new String[count];
        for (int i = 0, t = 0; i < statesOrTowns.length; i++) {
            if (statesOrTowns[i].length() != 2) {
                towns[t] = statesOrTowns[i];
                t++;
            }
        }

        System.out.printf("statesOrTowns array: %s%n", Arrays.toString(statesOrTowns));
        System.out.printf("towns two: %s%n", Arrays.toString(towns));
    }

    public static String[] makeRandomStateAndTownArray() {
        Random random = new Random();
        String[] result = new String[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            String value = "MN";
            switch (random.nextInt(8)) {
                case 0:
                    value = "AL";
                    break;
                case 1:
                    value = "AK";
                    break;
                case 2:
                    value = "AR";
                    break;
                case 3:
                    value = "AZ";
                    break;
                case 4:
                    value = "Boring";
                    break;
                case 5:
                    value = "Loafers Glory";
                    break;
                case 6:
                    value = "Handsome Eddy";
                    break;
                case 7:
                    value = "Lonelyville";
                    break;
            }
            result[i] = value;
        }
        return result;
    }
}
