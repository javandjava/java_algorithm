package com.istella.utils;

import java.util.*;

/**
 * @author liunan13
 * @date 2021/5/20
 * @description
 */
public class StringToMap {
    public static void main(String[] args){
//        String s="{bucket={id='account', count=3}, name=BucketLimitFilter, config={excludes=null, includes=null, code=-1, message='没有登录，请登录', status=-1, order=null, id='account', rate=3, full=3, f={id=1,count=2},initCount=50}, order=10}";
        String s="{config={setting={rate=1},name='test'},order=1}";
        Map map= convert(s);
        System.out.println(s);
        System.out.println(map);
    }

    /**
     *
     * @param s
     * @return
     */
    private static Map convert(String s){
        Map map=new HashMap();
        Stack<String> stack=new Stack<>();
        char[] arrays=s.toCharArray();
        for(char c :arrays){
            String t=String.valueOf(c);
            if(t.equals(" ")||t.equals("'"))
                continue;
//            System.out.println(t);
            if(t.equals("}")){
                String p=stack.pop();
                System.out.println(p);
                StringBuffer sb=new StringBuffer();
                while (!stack.empty()&&!p.equals("{")&&!p.equals(",")){
                    sb.append(p);
                    p=stack.pop();
                }
                String kvs=sb.reverse().toString();
                System.out.println("kvs:"+kvs);
                Map<String,Object> m=createMap(kvs);
                sb=new StringBuffer();
                if(!stack.empty()){
                    p=stack.pop();
                    while (!p.equals(",")&&!p.equals("{")){
                        sb.append(p);
                        p=stack.pop();
                    }
                }
                if(sb.length()>0) {
                    String k = sb.reverse().toString();
                    k = k.substring(0, k.length() - 1);
                    System.out.println(k);
                    map.put(k, m);
                }else {
                    for(Map.Entry<String,Object> entry:m.entrySet()){
                        map.put(entry.getKey(),entry.getValue());
                    }
                }
            }
            else {
                stack.push(t);
            }
        }

        return map;
    }

    private static Map createMap(String s){
        Map map=new HashMap();
        String[] kvs=s.split("[,]");
        for (String kvstr:kvs){
            String[] kv=kvstr.split("[=]");
            map.put(kv[0],kv[1]);
        }
        return map;
    }

    public static class Node{
        private String name;
        private List<Node> nodes;
    }
}
