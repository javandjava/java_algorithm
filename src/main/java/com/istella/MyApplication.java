package com.istella;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author liunan13
 * @date 2020/3/7
 * @description
 */
public class MyApplication {
    public static void main(String[] args){
        String s="{bucket={id='account', count=3}, name=BucketLimitFilter, config={excludes=null, includes=null, code=-1, message='没有登录，请登录', status=-1, order=null, id='account', rate=3, full=3, initCount=50}, order=10}";
        String p=format(s);
        System.out.println(p);
    }

    private static String format(String s){
        if(s.startsWith("{")&&s.endsWith("}"))
            return format(s.substring(1,s.length()-1));
        else if(s.startsWith("[")&&s.endsWith("]"))
            return format(s.substring(1,s.length()-1));
        else
            return s;
    }

    private static Map<String,String> formatMap(String s){
        Map<String,String> map=new HashMap<String, String>();



        return map;
    }

    private static  void reg(){
        //  正则
        Pattern p=Pattern.compile("^(account/a)$");
        String t="account/a/a";
        System.out.println(p);
        System.out.println(p.matcher(t).find());
    }
}
