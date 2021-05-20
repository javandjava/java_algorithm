package com.istella.algoriathm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liunan13
 * @date 2021/5/19
 * @description
 */
public class Intersect {

    public static void main(String[] args){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {1,1};
        int[] r=intersect(nums1,nums2);
        for(int i=0;i<r.length;i++){
            System.out.println(r[i]);
        }
    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶：
     *
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果nums1的大小比nums2小很多，哪种方法更优？
     * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> array=new ArrayList<>();

        for(int i=0;i<nums1.length;i++) {
            Integer t=map.get(nums1[i]);
            if (t == null) {
                map.put(nums1[i], 1);
            }else {
                map.put(nums1[i],t+1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            Integer t=map.get(nums2[i]);
            if(t!=null){
                t=t-1;
                array.add(nums2[i]);
                if(t==0)
                    map.remove(nums2[i]);
                else
                    map.put(nums2[i],t);
            }
        }

        int[] r=new int[array.size()];
        for(int i=0;i<array.size();i++){
            r[i]=array.get(i);
        }
        return r;
    }
}
