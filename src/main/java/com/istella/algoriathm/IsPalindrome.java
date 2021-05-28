package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/27
 * @description
 */
public class IsPalindrome {
    public static void main(String[] args){
        String s="A man, a plan, a canal: Panama";
        boolean r=isPalindrome(s);
        System.out.println(r);
    }

    public static boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while (l<r){
            char sl=s.charAt(l);
            if(!Character.isLetterOrDigit(sl)){
                l++;
                continue;
            }

            char sr=s.charAt(r);
            if(!Character.isLetterOrDigit(sr)){
                r--;
                continue;
            }

            if(Character.toLowerCase(sl)!=Character.toLowerCase(sr)){
                return false;
            }
            r--;
            l++;
        }
        return true;
    }
}
