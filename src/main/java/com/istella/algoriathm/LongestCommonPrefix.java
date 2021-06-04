package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/6/3
 * @description
 */
public class LongestCommonPrefix {

    public static void main(String[] args){
        String[] s={"flower","flow","flight"};
        String r=longestCommonPrefix(s);
        System.out.println(r);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
            return "";

        int total=strs[0].length();
        int size=strs.length;
        StringBuffer s=new StringBuffer(total);
        for (int p=0;p<total;p++) {
            char c = strs[0].charAt(p);
            for (int i = 1; i < size; i++) {
                if(p>=strs[i].length()||strs[i].charAt(p)!=c)
                    return s.toString();
            }
            s.append(c);
        }
        return s.toString();

    }
}
