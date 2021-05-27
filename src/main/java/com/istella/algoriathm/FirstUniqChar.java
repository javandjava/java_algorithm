package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/27
 * @description
 */
public class FirstUniqChar {

    public static void main(String[] args){
        String s="loveleetcode";
        int r=firstUniqChar(s);
        System.out.println(r);
    }

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        int[] chars={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        char[] cs=s.toCharArray();
        for(int i=0;i<cs.length;i++){
            int p=cs[i]-'a';
            if(chars[p]==-1){
                chars[p]=i;
            }else {
                chars[p]=100;
            }
        }

        int i=-1;
        for(int p=0;p<26;p++){
            System.out.println(chars[p]);
            if(chars[p]!=-1&&chars[p]!=100&&(i==-1||chars[p]<i)){
                i=chars[p];
            }
            System.out.println("i="+i);
        }
        return i;
    }
}
