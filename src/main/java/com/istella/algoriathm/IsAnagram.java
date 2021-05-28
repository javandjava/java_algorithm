package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/27
 * @description
 */
public class IsAnagram {

    public static void main(String[] args){
        String s1="anagram";
        String s2="nagaram";
        boolean r=isAnagram(s1,s2);
        System.out.println(r);
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;

        int[][] chars=new int[26][2];
        char[] c1=s.toCharArray();
        char[] c2=t.toCharArray();

        for(int i=0;i<c1.length;i++){
            chars[c1[i]-'a'][0]++;
        }

        for(int i=0;i<c2.length;i++){
            chars[c2[i]-'a'][1]++;
        }

        for(int i=0;i<26;i++){
            if(chars[i][0]!=chars[i][1])
                return false;
        }

        return true;
    }
}
