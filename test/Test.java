import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangchd  2018/4/18.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1,2,-2,-1}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rList = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return rList;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = -nums[i];
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    rList.add(triplet);
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < sum) {
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                } else {
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                }
            }
        }
        return rList;
    }
}
