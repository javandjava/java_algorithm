package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/26
 * @description
 */
public class Reverse {

    public static void main(String[] args){
        int num=1534236469;
        int r= reverse(num);
        System.out.println(r);
    }

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     *
     * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
     *
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long r=0;
        while (Math.abs(x)>0){
            r=r*10+x%10;
            x=x/10;
        }

        return (int)r==r?(int)r:0;
    }
}
