package com.tangtang.basic.node;

/**
 * 链表逆转
 */
public class ReverseNode {

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node next(Node n) {
            next = n;
            return n;
        }
    }

    public static class DoubleNode {
        int value;

        DoubleNode last;
        DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     * 单链表反转
     *
     * @param head head
     * @return
     */
    public static Node reverseNode(Node head) {
        Node pre = null;
        Node next = null;
//        while (head != null) {
//            pre = head.next;
//            head.next = next;
//            next = head;
//            head = pre;
//        }
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 双链表反转
     *
     * @param head head
     * @return
     */
    public static DoubleNode reverseDoubleNode(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next(new Node(2)).next(new Node(3));
        Node reverseNode = reverseNode(n1);
        System.out.println();

        DoubleNode db1 = new DoubleNode(1);
        DoubleNode db2 = new DoubleNode(2);
        DoubleNode db3 = new DoubleNode(3);
        db1.last = null;
        db1.next = db2;
        db2.last = db1;
        db2.next = db3;
        db3.last = db2;
        db3.next = null;
        DoubleNode reserveDoubleNode = reverseDoubleNode(db1);
        System.out.println();


    }
}
