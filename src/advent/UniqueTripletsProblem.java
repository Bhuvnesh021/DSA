package advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueTripletsProblem {
    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 1, 2, -1, 4};

        // Sort the array to apply the two-pointer technique
        Arrays.sort(array);

        // Find triplets that sum to zero
        List<List<Integer>> result = findTriplets(array);

        // Print the result
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }

    private static List<List<Integer>> findTriplets(int[] array) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < array.length - 2; i++) {
            // Skip duplicate elements to avoid duplicate triplets
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = array.length - 1;

            while (left < right) {
                int sum = array[i] + array[left] + array[right];

                if (sum == 0) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));

                    // Skip duplicate elements for left and right pointers
                    while (left < right && array[left] == array[left + 1]) left++;
                    while (left < right && array[right] == array[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Move left pointer to increase the sum
                } else {
                    right--; // Move right pointer to decrease the sum
                }
            }
        }

        return result;
    }
}
