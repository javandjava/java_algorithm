package com.istella.algoriathm.link;

/**
 * @author liunan13
 * @date 2021/6/4
 * @description
 */
public class Link {

    public static void main(String[] args){
        int[] ns={1,2,3,4,5};
        ListNode head=new ListNode(ns[0]);
        ListNode t=head;
        for (int n=1;n<ns.length;n++){
            ListNode node=new ListNode(ns[n]);
            head.next=node;
            head=node;
        }

        t=removeNthFromEnd(t,5);

        while (t!=null){
            System.out.println(t.val);
            t=t.next;
        }

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
