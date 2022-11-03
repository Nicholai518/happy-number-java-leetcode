import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        // used to store numbers we have seen
        HashSet<Integer> seen = new HashSet<>();

        // loop
        while (n != 1) {
            int current = n;
            int sum = 0;

            // iterating through all of the numbers within a number
            // ex: 19
            // first iteration = 9
            // second iteration = 1
            while (current != 0) {

                // mod 10 will always give us the last digit of number
                // multiply by itself to get the square value
                sum += (current % 10) * (current % 10);

                // get the next number by moving left
                current /= 10;
            }

            // we have already seen this number
            // we are in endless loop, return false
            if (seen.contains(sum)) {
                return false;
            }

            // add sum to HashSet to avoid endless loops
            seen.add(sum);

            // update n for next iteration
            n = sum;
        }

        return true;
    }
}
