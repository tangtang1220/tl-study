package com.tangtang.basic.node;

/**
 * 队列 和 栈
 */
public class LinkedListToQueueAndStack {

    public static class Node<V> {
        V value;

        Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }


    /**
     * 队列
     *
     * @param <V>
     */
    public static class MyQueue<V> {
        Node<V> head;
        Node<V> tail;
        int size;

        /**
         * 队列是否为空
         *
         * @return true 空，false 不空
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 元素个数
         *
         * @return int
         */
        public int size() {
            return size;
        }

        /**
         * 添加元素
         */
        public void offer(V value) {
            Node<V> node = new Node<>(value);
            if (tail == null && head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        /**
         * 弹出元素
         *
         * @return V
         */
        public V poll() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            } else {
                tail = null;
            }
            return ans;
        }

        /**
         * 查看当前可用元素
         */
        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }
    }

    /**
     * 栈
     */
    public static class MyStack<V> {
        Node<V> head;
        int size;

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        /**
         * 添加元素
         *
         * @param value value
         */
        public void offer(V value) {
            Node<V> node = new Node<>(value);
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }

        /**
         * 获取元素
         *
         * @return V
         */
        public V poll() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }

        /**
         * 获取当前可用元素
         *
         * @return V
         */
        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }

    }


    public static void main(String[] args) {
        // 队列测试
        MyQueue<Integer> queue = new MyQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("当前可用元素:" + queue.peek());
        System.out.println("取出当前元素:" + queue.poll());
        System.out.println("当前可用元素:" + queue.peek());
        System.out.println("取出当前元素:" + queue.poll());
        System.out.println("当前可用元素:" + queue.peek());
        System.out.println("取出当前元素:" + queue.poll());
        System.out.println("==========================");
        // 栈测试
        MyStack<String> stack = new MyStack<>();
        stack.offer("1");
        stack.offer("2");
        stack.offer("3");
        System.out.println("当前可用元素:" + stack.peek());
        System.out.println("取出当前元素:" + stack.poll());
        System.out.println("当前可用元素:" + stack.peek());
        System.out.println("取出当前元素:" + stack.poll());
        System.out.println("当前可用元素:" + stack.peek());
        System.out.println("取出当前元素:" + stack.poll());
    }
}
