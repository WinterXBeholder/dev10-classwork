public class Exercise25 {

    // Mad Libs: https://en.wikipedia.org/wiki/Mad_Libs
    // 1. Add a main method.
    // 2. Declare several variables of various types to be "plugged in" to a Mad Libs sentence.
    // 3. Use string concatenation to build a silly sentence.
    // 4. Print the result.
    // 5. Change variable values to change the sentence. Ask a friend for random values to increase the chances
    // of something hilarious or kinda naughty.
    public static void main(String[] args) {
        String name = "Brian";
        int age = 29;
        float address = 3.34f;
        double cost = 22.55;
        String food = "rice";
        long distance = 6;
        char aisle = 'A';
        String friend = "Alexa";
        boolean result = true;

        String sentance = name + " went to the store at  " + address + " street. He had to walk " + distance + " miles. He found the " + food + " in aisle " + aisle + " for $" + cost + ". When he asked  " + friend + " if it was fresh, she replied " + result + " .";
        System.out.println(sentance);

        name = "Spot";
        age = 4;
        address = 17.7f;
        cost = 999.666;
        food = "lollipops";
        distance = 3541;
        aisle = 'G';
        friend = "Mr Whiskers";
        result = false;

        sentance = name + " went to the store at  " + address + " street. He had to walk " + distance + " miles. He found the " + food + " in aisle " + aisle + " for $" + cost + ". When he asked  " + friend + " if it was fresh, she replied " + result + " .";
        System.out.println(sentance);
    }
}
