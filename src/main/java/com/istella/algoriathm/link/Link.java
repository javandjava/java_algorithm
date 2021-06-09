package com.istella.algoriathm.link;

/**
 * @author liunan13
 * @date 2021/6/4
 * @description
 */
public class Link {

    public static void main(String[] args){
        int[] ns={1};
//        int[] ns1={1,2,4};
//        int[] ns2={1,3,4};
//        ListNode c;
//        ListNode head=new ListNode(ns[0]);
//        c=head;
//        for (int n=1;n<ns.length;n++){
//            ListNode node=new ListNode(ns[n]);
//            c.next=node;
//            c=node;
//        }
//
//        ListNode head1=new ListNode(ns1[0]);
//        c=head1;
//        for (int n=1;n<ns1.length;n++){
//            ListNode node=new ListNode(ns1[n]);
//            c.next=node;
//            c=node;
//        }
//
//        ListNode head2=new ListNode(ns2[0]);
//        c=head2;
//        for (int n=1;n<ns2.length;n++){
//            ListNode node=new ListNode(ns2[n]);
//            c.next=node;
//            c=node;
//        }
//        ListNode t=mergeTwoLists(head1,head2);
//        while (t!=null){
//            System.out.println(t.val);
//            t=t.next;
//        }

//        System.out.println(isPalindrome(head));

        int pos=-1;
        int p=0;
        ListNode cycle=null;
        ListNode c;
        ListNode head=new ListNode(ns[0]);
        c=head;
        for (int n=1;n<ns.length;n++){
            ListNode node=new ListNode(ns[n]);
            if(pos==n)
                cycle=node;
            c.next=node;
            c=node;
        }

        if(cycle!=null){
            c.next=cycle;
        }

        c=head;
        int time=0;
        while (c!=null){
            System.out.println(c.val);
            if(cycle==c){
                if(time>=1)
                    break;
                time++;
            }
            c=c.next;
        }

        System.out.println(hasCycle(head));

    }

    /**
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode c=head;
        ListNode fc=head;
        while (fc!=null&&fc.next!=null){
            fc=fc.next.next;
            c=c.next;
            if(fc==c)
                return true;
        }

        return false;
    }


    /**
     * 请判断一个链表是否为回文链表。
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        int total=0;
        ListNode node=head;
        while (node!=null){
            total++;
            node=node.next;
        }
        if(total==1)
            return true;
        int m=total%2;
        total=total/2;
        ListNode[] nodes=new ListNode[total];
        node=head;
        int p=0;
        for(;p<total;p++){
            nodes[p]=node;
            node=node.next;
        }
        if(m==1){
            node=node.next;
        }
        while (node!=null){
            p--;
            if(nodes[p].val!=node.val){
                return false;
            }
            node=node.next;
        }

        return true;
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        ListNode head=new ListNode(l1.val);
        ListNode c1=l1;
        ListNode c2=l2;
        if(c1.val<c2.val){
            head.val=c1.val;
            c1=c1.next;
        }else {
            head.val=c2.val;
            c2=c2.next;
        }
        ListNode t=head;
        while (c1!=null||c2!=null){
            if(c1==null) {
                t.next = c2;
                break;
            }
            else if(c2==null) {
                t.next = c1;
                break;
            }
            else if(c1.val<= c2.val){
                t.next=new ListNode(c1.val);
                c1=c1.next;
            }else {
                t.next=new ListNode(c2.val);
                c2=c2.next;
            }
            t=t.next;
        }

        return head;
    }

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode c=head;
        ListNode next=head.next;
        c.next=null;
        while (next!=null){
            ListNode t=next.next;
            next.next=c;
            c=next;
            next=t;
        }
        return c;
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)
            return null;

        ListNode[] nodes=new ListNode[30];
        ListNode node=head;
        int p=0;
        while (node!=null){
            nodes[p]=node;
            node=node.next;
            p++;
        }

        //删除尾节点
        if (n==1){
            nodes[p-2].next=null;
            return head;
        }

        //删除头节点
        if(p==n){
            head=nodes[1];
            return head;
        }

        // 其他
        nodes[p-n].val=nodes[p-n+1].val;
        nodes[p-n].next=nodes[p-n+1].next;
        return head;
    }

    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     * @param node
     */
    public void deleteNode(ListNode node){
        node.val=node.next.val;
        node.next=node.next.next;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
