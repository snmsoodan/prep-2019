import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        if(nums.length<3) return list;
        Arrays.sort(nums);
        int j, k;
        for(int i=0;i<nums.length;i++) {
            //never let i refer to the same value
            if(i!=0 && nums[i]==nums[i-1]) continue;
            j=i+1;
            k=nums.length-1;
            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    ////never let j refer to the same value
                    while(j<k && nums[j] == nums[j-1]) j++;
                }
                else if(sum < 0) j++;
                else k--;
            }

        }
        return list;
        
    }
}