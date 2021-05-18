package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/18
 * @description
 */
public class MaxProfit {

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int profit=maxProfit(prices);
        System.out.println(profit);
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
}
