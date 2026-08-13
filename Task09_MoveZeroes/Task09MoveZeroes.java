import java.util.Arrays;

public class Task09MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("Input: " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }
}
