package com.istella.algoriathm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liunan13
 * @date 2021/5/21
 * @description
 */
public class TwoSum {
    public static void main(String[] args){
        int[] nums = {3,2,4};
        int target=6;
        int[] p=twoSum(nums,target);
        System.out.println(p[0]+","+p[1]);
    }

    /**
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer p=map.get((target-nums[i]));
            if(p!=null){
                return new int[]{i,p};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
