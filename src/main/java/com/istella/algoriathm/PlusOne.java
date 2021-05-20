package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/20
 * @description
 */
public class PlusOne {
    public static void main(String[] args){
        int[] nums1 = {1,2,3};
        int[] digits=plusOne(nums1);
        for(int i=0;i<digits.length;i++)
            System.out.println(digits[i]);
    }

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            if(digits[i]==10){
                digits[i]=0;
            }else {
                return digits;
            }
        }
        if(digits[0]==0){
            int[] newdigist=new int[digits.length+1];
            newdigist[0]=1;
            for(int i=0;i<digits.length;i++){
                newdigist[1+i]=digits[i];
            }
            return newdigist;
        }
        return digits;
    }
}
