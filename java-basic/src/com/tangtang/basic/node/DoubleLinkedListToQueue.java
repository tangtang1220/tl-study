package com.tangtang.basic.node;

/**
 * 双向链表队列
 */
public class DoubleLinkedListToQueue {

    /**
     * 双向链表
     *
     * @param <V>
     */
    public static class Node<V> {
        V value;
        Node<V> last;
        Node<V> next;

        public Node(V value) {
            this.value = value;
            last = null;
            next = null;
        }
    }

    public static class MyQueue<V> {
        Node<V> head;  // 第一个元素
        Node<V> tail; // 最后一个元素
        int size; // 队列常熟

        /**
         * 对列是否为空
         *
         * @return boolean
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 返回元素个数
         *
         * @return int
         */
        public int size() {
            return size;
        }

        /**
         * 默认添加元素到最后
         *
         * @param value v
         */
        public void offer(V value) {
            offer(value, false);
        }

        /**
         * 添加元素在第一个
         *
         * @param value V
         */
        public void offerFirst(V value) {
            offer(value, true);
        }

        /**
         * 添加元素在最后一个
         *
         * @param value V
         */
        public void offerLast(V value) {
            offer(value);
        }

        /**
         * 添加元素
         */
        private void offer(V value, boolean isFirst) {
            Node<V> node = new Node<>(value);
            if (head == null && tail == null) {
                head = node;
                tail = node;
            } else if (isFirst) {
                node.next = head;
                head.last = node;
                head = node;
            } else {
                node.last = tail;
                tail.next = node;
                tail = node;
            }
            size++;
        }

        /**
         * 获取第一个的元素
         *
         * @return V
         */
        public V pollFirst() {
            return poll(true);
        }

        /**
         * 获取最后一个的元素
         *
         * @return V
         */
        public V pollLast() {
            return poll(false);
        }

        /**
         * 获取第一个元素
         */
        private V poll(boolean isFirst) {
            V ans = null;
            if (head == null && tail == null) {
                return ans;
            }
            if (size == 1) {
                ans = head.value;
                head = null;
                tail = null;
            } else if (isFirst) {
                ans = head.value;
                head = head.next;
                head.last = null;
            } else {
                ans = tail.value;
                tail = tail.last;
                tail.next = null;
            }
            size--;
            return ans;
        }

        /**
         * 获取当前队列第一个元素
         *
         * @return V
         */
        public V peekFirst() {
            return peek(true);
        }

        /**
         * 获取当前队列最后一个元素
         *
         * @return V
         */
        public V peekLast() {
            return peek(false);
        }

        private V peek(boolean isFirst) {
            V ans = null;
            if (head == null && tail == null) {
                return ans;
            }
            if (isFirst) {
                ans = head.value;
            } else {
                ans = tail.value;
            }
            return ans;
        }

    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offerFirst(0);
        queue.offerLast(4);
        System.out.println("当前元素个数:" + queue.size());
        System.out.println("当前队列第一个元素:" + queue.peekFirst());
        System.out.println("取出队列第一个元素:" + queue.pollFirst());
        System.out.println("当前队列第一个元素:" + queue.peekFirst());
        System.out.println("当前队列最后一个元素:" + queue.peekLast());
        System.out.println("取出队列最后一个元素:" + queue.pollLast());
        System.out.println("当前队列最后一个元素:" + queue.peekLast());
        System.out.println("取出队列最后一个元素:" + queue.pollLast());
        System.out.println("取出队列最后一个元素:" + queue.pollLast());
        System.out.println("取出队列第一个一个元素:" + queue.pollFirst());
        System.out.println("取出队列最后一个元素:" + queue.pollLast());
        System.out.println("取出队列最后一个元素:" + queue.pollLast());
    }
}
