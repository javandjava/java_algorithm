package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/28
 * @description
 */
public class Atoi {
    public static void main(String[] args){
        String s="words and 987";
        int r=myAtoi(s);
        System.out.println(r);
    }

    public static int myAtoi(String s) {
        if(s.length()>200||s.length()==0)
            return 0;
        int r=0;
        int temp=0;
        boolean minus=false;
        s=s.trim();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='-'){
                if(i>0)
                    break;
                minus=true;
            }else if(c=='+'){
                if(i>0)
                    break;
                continue;
            } else if(Character.isDigit(c)){
                int tc=c-'0';
                temp=r;
                r=r*10+tc;
                if(r/10 !=temp){
                    if(minus){
                        return Integer.MIN_VALUE;
                    }else {
                        return Integer.MAX_VALUE;
                    }
                }
            }else {
                break;
            }
        }
        return minus?-r:r;
    }
}
