package com.example.helloworld.adobe;



class Solution1 {

    public static class LinkList {
        LinkList next;
        Integer val;

        public LinkList(Integer val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("Chirag's solution. I'm better now.");
        LinkList head=new LinkList(1);
        head.next =new LinkList(2);
        head.next.next=new LinkList(3);
        // continue
        linkListPrint(head);
    }
    private static int linkListPrint(LinkList curr){
        if( curr == null)
            return 0;

        int pos=linkListPrint(curr.next);

        if(pos%2==0){
            System.out.println(curr.val);
        }
        return pos+1;
    }
}
