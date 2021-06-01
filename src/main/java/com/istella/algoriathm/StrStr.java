package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/31
 * @description
 */
public class StrStr {
    public static void main(String[] args){
        String s1="aaa";
        String s2="aaaa";
        int i=strStr(s1,s2);
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {
        if(needle==null||needle.equals(""))
            return 0;

        char[] chars1=haystack.toCharArray();
        char[] chars2=needle.toCharArray();

        for(int i=0;i<chars1.length;i++){
            int t=0;
            while (t<chars2.length&&(i+t)<chars1.length&&chars1[i+t]==chars2[t]){
                t++;
            }
            if(t==chars2.length){
                return i;
            }
        }

        return -1;
    }
}
