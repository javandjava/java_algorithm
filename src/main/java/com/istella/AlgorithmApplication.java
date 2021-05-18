package com.istella;

/**
 * @author liunan13
 * @date 2021/5/13
 * @description
 */
public class AlgorithmApplication {
    public static void main(String[] args){
//        int[] nums={0,0,1,1,2,2,3,3,3,3,4,4,5,5,5};
//        int l=removeDuplicates(nums);
//        System.out.println(l);
//        for(int i=0;i<nums.length;i++){
//            System.out.println(nums[i]);
//        }

        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        for(int i=0;i<nums.length;i++)
            System.out.println(nums[i]);
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

    /**
     * 给定一个数组 prices ，prices[i] 是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int profit=0;
        int c=0;
        int p=1;
        while (p<prices.length){
            //比前一天价格低，使用前一天的价格卖出，买入当天
            if(prices[p]<prices[p-1]){
                profit+=prices[p-1]-prices[c];
                c=p;
            }
            p++;
        }
        //最后一次买入，一直涨价，最后一天卖出
        if(prices[prices.length-1]>prices[c])
            profit+=prices[prices.length-1]-prices[c];

        return profit;
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
