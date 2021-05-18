package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/18
 * @description
 */
public class RemovDuplicates {

    public static void main(String[] args){
        int[] nums={1,2,2,3,3,3,4,4,4,4,5};
        int c=removeDuplicates(nums);
        System.out.println(c);
    }

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 作者：力扣 (LeetCode)
     * 链接：{@Link https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/}
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums){
        int p=1;
        int c=0;
        while (p<nums.length){
            if(nums[p]==nums[c])
                p++;
            else {
                nums[c + 1] = nums[p];
                c++;
            }
        }
        return c+1;
    }
}
