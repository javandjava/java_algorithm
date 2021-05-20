package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/20
 * @description
 */
public class MoveZeroes {
    public static void main(String[] args){
        int[] nums1 = {0,1,0,3,12};
        moveZeroes(nums1);
        for(int i=0;i<nums1.length;i++)
            System.out.println(nums1[i]);
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p] = nums[i];
                p++;
            }
        }
        //后面的都是0,
        while (p<nums.length) {
            nums[p] = 0;
            p++;
        }

    }
}
