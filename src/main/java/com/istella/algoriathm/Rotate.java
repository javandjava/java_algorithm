package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/18
 * @description
 */
public class Rotate {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        for(int i=0;i<nums.length;i++)
            System.out.println(nums[i]);
    }

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * @param nums
     * @param k
     */
//    public static void rotate(int[] nums, int k) {
//        int n=nums.length==0?0:k%nums.length;
//        int[] t=new int[n];
//        for(int i=0;i<nums.length;i++){
//            int p=nums.length-1-i;
//            if(i<n)
//                t[n-1-i]=nums[nums.length-1-i];
//            if(p>=n)
//                nums[p]=nums[p-n];
//            else
//                nums[p]=t[p];
//        }
//    }

    public static void rotate(int[] nums, int k) {
        int n=nums.length==0?0:k%nums.length;
        int[] t=new int[n];
        for(int i=0;i<n;i++){
            t[n-1-i]=nums[nums.length-1-i];
        }
        for(int i=0;i<nums.length-n;i++){
            int p=nums.length-1-i;
            nums[p]=nums[p-n];
        }
        for(int i=0;i<n;i++){
            nums[i]=t[i];
        }
    }
}
