package me.skygod.itheima.ThreeMonks;

public class Max {
    public static int getMax(int[] nums){
        int max = nums[0];
        for(int i : nums){
            if(i>max){
                max=i;
            }
        }
        return max;
    }
}
