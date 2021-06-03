package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/31
 * @description
 */
public class CountAndSay {
    public static void main(String[] args){
        int n=4;
        String s=countAndSay(n);
        System.out.println(s);
    }

    /**
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     *
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        String r="1";
        int p=0;
        char c='1';
        int total=0;
        for(int i=1;i<n;i++){
            char[] chars=r.toCharArray();
            r="";
            while (p<chars.length){
                if (chars[p] == c) {
                    total++;
                } else {
                    r+=total;
                    r+=c;
                    total=1;
                    c=chars[p];
                }
                p++;
            }
            r+=total;
            r+=c;
            total=0;
            p=0;
            c=r.charAt(0);
        }

        return r;
    }
}
